package com.tdysj.dorm.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Create by yachtcay
 * @date 2020/2/24 14:52
 */
@Data
@Component
@ConfigurationProperties("whistle")
public class UploadConfig {
    /**
     * 上传文件路径
     */
    private String uploadPath;
}
