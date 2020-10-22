package com.tdysj.dorm.common.exception;

public class IdException extends RuntimeException {

    public IdException() {
        super();
    }

    public IdException(String message) {
        super(message);
    }

    public IdException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdException(Throwable cause) {
        super(cause);
    }
}
