package com.tdysj.dorm.common.security.constants;

/**
 * Security 常量
 * @author Create by yachtcay
 * @date 2019/12/31 10:15
 */
public interface SecurityConstants {

    /**
     * 角色前缀
     */
    String ROLE_PREFIX = "ROLE_";

    /**
     * 登录的地址
     */
    String AUTH_LOGIN_URL = "/auth/login";
    String LOGOUT="/logout";
    /**
     * 角色的key
     **/
    String ROLE_CLAIMS = "rol";
    /**
     * rememberMe 为 false 的时候过期时间是1个小时
     */
    long EXPIRATION = 60 * 60L;
    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;

    /**
     * JWT签名密钥硬编码到应用程序代码中，应该存放在环境变量或.properties文件中。
     */
    String JWT_SECRET_KEY = "C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w";

    // JWT token defaults

    /**
     * token 头
     */
    String TOKEN_HEADER = "Authorization";
    /**
     * token 值前缀
     */
    String TOKEN_PREFIX = "Bearer ";
    /**
     * token 类型
     */
    String TOKEN_TYPE = "JWT";

    /**
     * 拦截的请求
     */
    String[] INTERCEPT_MAPPING = {
            "/sys/**",
            "/dorm/**"
    };

    /**
     * 不拦截的请求
     */
    String[] PERMIT_ALL_MAPPING = {
             AUTH_LOGIN_URL,
            LOGOUT
    };
}
