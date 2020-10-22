package com.tdysj.dorm.common.constant;

/**
 * sharding-jdbc所用常量
 */
public interface ShardingConstant {

    /**
     * 分片键：id
     */
    String SHARDING_FIELD_ID = "id";

    /**
     * 分片键：created_time
     */
    String SHARDING_FIELD_TIME = "created_time";

    /**
     * 正则模型：市级案件id
     */
    String PATTERN_CASE_ID_KM = "^CK\\d{13}$";

    /**
     * 正则模型：盘龙案件id
     */
    String PATTERN_CASE_ID_PL = "^C\\d{13}$";
}
