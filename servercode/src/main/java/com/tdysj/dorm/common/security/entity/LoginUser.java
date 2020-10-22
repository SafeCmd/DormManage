package com.tdysj.dorm.common.security.entity;

import lombok.Data;

/**
 * @author Create by yachtcay
 * @date 2019/12/31 10:33
 */
@Data
public class LoginUser {

    private String username;
    private String password;
    private Boolean rememberMe;

}
