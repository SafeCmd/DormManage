package com.tdysj.dorm.common.utils;


import com.tdysj.dorm.common.exception.IdException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Twitter_Snowflake<br>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位dataCenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 *
 * @author mjy
 */
public class SnowflakeGenerator {

    /**
     * snowflake起始时间戳（2016-11-26 21:21:05）
     */
    private final static long START_TIMESTAMP = 1480166465631L;
    /**
     * 序列号占用的位数
     */
    private final static long SEQUENCE_BIT = 12L;
    /**
     * 机器标识占用的位数
     */
    private final static long WORKER_BIT = 5L;
    /**
     * 数据中心占用的位数
     */
    private final static long DATA_CENTER_BIT = 5L;
    /**
     * 支持的最大数据标识id，结果是31
     */
    private final static long MAX_DATA_CENTER_NUM = ~(-1L << DATA_CENTER_BIT);
    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private final static long MAX_WORKER_NUM = ~(-1L << WORKER_BIT);
    /**
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);
    /**
     * 机器ID向左移12位
     */
    private final static long WORKER_LEFT = SEQUENCE_BIT;
    /**
     * 数据标识id向左移17位(12+5)
     */
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + WORKER_BIT;
    /**
     * 时间截向左移22位(5+5+12)
     */
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;
    /**
     * 数据中心ID(0~31)
     */
    private static long dataCenterId;
    /**
     * 工作机器ID(0~31)
     */
    private static long workerId;
    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;
    /**
     * 上次生成ID的时间截
     */
    private long lastTimestamp = -1L;
    /**
     * 日历
     */
    private static Calendar calendar = Calendar.getInstance();

    public SnowflakeGenerator() {
    }

    /**
     * 设置配置
     *
     * @param dataCenterId 数据中心ID
     * @param workerId 工作机器ID
     */
    public static void setConfiguration(long dataCenterId, long workerId) {
        if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
            throw new IdException(String.format("data center Id can't be greater than %d or less than 0", MAX_DATA_CENTER_NUM));
        }
        if (workerId > MAX_WORKER_NUM || workerId < 0) {
            throw new IdException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_NUM));
        }
        SnowflakeGenerator.dataCenterId = dataCenterId;
        SnowflakeGenerator.workerId = workerId;
    }

    /**
     * 解析snowflake生成的id获取年
     *
     * @param id 雪花算法id
     * @return 当前雪花算法中的年
     */
    public static String getYear(String id) {
        String binaryId = Long.toBinaryString(Long.parseLong(id));
        int len = binaryId.length();
        int timeEnd = (int) (len - TIMESTAMP_LEFT);
        String time = binaryId.substring(0, timeEnd);
        calendar.setTimeInMillis(Long.parseLong(time, 2) + START_TIMESTAMP);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    /**
     * 产生下一个ID
     *
     * @return 新ID
     */
    public synchronized long nextId() {
        long currentTimestamp = getNewTimestamp();
        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (currentTimestamp < lastTimestamp) {
            throw new IdException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - currentTimestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (currentTimestamp == lastTimestamp) {
            // 相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // 毫秒内序列溢出
            if (sequence == 0L) {
                // 阻塞到下一个毫秒,获得新的时间戳
                currentTimestamp = getNextMill();
            }
        } else {
            //时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        // 上次生成ID的时间截
        lastTimestamp = currentTimestamp;
        //移位并通过或运算拼到一起组成64位的ID
        return (currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT //时间戳部分
                | SnowflakeGenerator.dataCenterId << DATA_CENTER_LEFT       //数据中心部分
                | SnowflakeGenerator.workerId << WORKER_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @return 当前时间戳
     */
    private long getNextMill() {
        long mill = getNewTimestamp();
        while (mill <= lastTimestamp) {
            mill = getNewTimestamp();
        }
        return mill;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间戳
     */
    private long getNewTimestamp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        String binaryId = Long.toBinaryString(Long.parseLong("416663984637214720"));
        System.out.println(binaryId.length());
        System.out.println(binaryId);
        int timeEnd = (int) (binaryId.length() - TIMESTAMP_LEFT);
        String time = binaryId.substring(0, timeEnd);
        System.out.println(time);
        long timestamp = Long.parseLong(time, 2) + START_TIMESTAMP;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String str = dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
        System.out.println(str);
    }
}
