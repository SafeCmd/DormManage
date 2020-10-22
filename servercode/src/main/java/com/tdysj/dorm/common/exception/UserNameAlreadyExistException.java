package com.tdysj.dorm.common.exception;

/**
 * @author Create by yachtcay
 * @date 2019/12/31 11:00
 */
public class UserNameAlreadyExistException extends RuntimeException {

    public UserNameAlreadyExistException() {
    }

    public UserNameAlreadyExistException(String message) {
        super(message);
    }
}
