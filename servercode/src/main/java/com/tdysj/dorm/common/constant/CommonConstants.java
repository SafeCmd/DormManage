package com.tdysj.dorm.common.constant;

/**
 * @author Create by yachtcay
 * @date 2019/7/10 15:49
 */
public interface CommonConstants {

    /**
     * 超级管理员id
     */
    Integer ADMIN_ID = 1;

    /**
     * 顶级节点id
     */
    Integer TOP_NODE = 0;

    /**
     * 成功状态
     */
    Integer SUCCESS = 0;
    /**
     * 失败状态
     */
    Integer FAIL = 1;
    /**
     * 成功提示
     */
    String SUCCESS_MESSAGE = "success";
    /**
     * 失败提示
     */
    String FAIL_MESSAGE = "fail";

    /**
     * 删除
     */
    String STATUS_DEL = "1";
    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json;charset=utf-8";

    /**
     * 逗号
     */
    String COMMA = ",";

    /**
     * 连字符
     */
    String HYPHEN = "-";

    /**
     * list 大小为0
     */
    Integer LIST_SIZE_ZERO = 0;

    /**
     * list 第一条数据
     */
    Integer LIST_INDEX_ZERO = 0;
    /**
     * 空字符
     */
    String EMPTY = "";

    /*******************  文件路径 ******************/

    String VISIT_STATIC_FILE_PATH = "/get/files/";//默认路径
    String WORK_PROGRAMME_FILE = "WorkProgramme_file/";//工作方案文件
    String HANDLE_BACK_FILE = "handleBack_file/";//处置结果文件
    String JUDGED_FILE = "judged_file/";//处置结果文件
    String USER_PIC_PATH = "avatar/";//用户头像
}
