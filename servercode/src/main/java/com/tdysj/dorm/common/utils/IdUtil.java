package com.tdysj.dorm.common.utils;

import com.tdysj.dorm.common.constant.CommonConstants;
import com.tdysj.dorm.common.constant.ShardingConstant;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mjy
 */
@UtilityClass
public class IdUtil {

    /**
     * 雪花id生成器
     */
    private static SnowflakeGenerator snowflakeGenerator = new SnowflakeGenerator();

    /**
     * 市级案件id正则
     */
    private final Pattern CASE_ID_KM = Pattern.compile(ShardingConstant.PATTERN_CASE_ID_KM);

    /**
     * 盘龙案件id正则
     */
    private final Pattern CASE_ID_PL = Pattern.compile(ShardingConstant.PATTERN_CASE_ID_PL);

    /**
     * 雪花算法id
     *
     * @return 字符串形式的雪花算法id
     */
    public static String snowflakeId() {
        return String.valueOf(snowflakeGenerator.nextId());
    }

    /**
     * uuid
     *
     * @return 无连字符的uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll(CommonConstants.HYPHEN, CommonConstants.EMPTY);
    }

    /**
     * 当前系统中全数字id为雪花算法id，非全数字id为国研id
     * 国研id中案件id分为两种："CKyyyyMMdd\d{5}"（市级案件）和"CyyyyMMdd\d{5}"(盘龙案件)
     *
     * @param id id
     * @return
     */
    public static String parseYearFromId(String id) {
        if (StringUtils.isNumeric(id)) {
            return SnowflakeGenerator.getYear(id);
        } else {
            Matcher kmMatcher = CASE_ID_KM.matcher(id);
            if (kmMatcher.find()) {
                return id.substring(2, 6);
            }
            Matcher plMatcher = CASE_ID_PL.matcher(id);
            if (plMatcher.find()) {
                return id.substring(1, 5);
            }
        }
        return null;
    }
}
