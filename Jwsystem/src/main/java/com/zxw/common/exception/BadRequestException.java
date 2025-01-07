package com.zxw.common.exception;

public class BadRequestException extends RuntimeException {
    // 构造方法：使用指定的详细消息创建一个新的实例。
    public BadRequestException(String message) {
        super(message);
    }

    // 构造方法：使用指定的详细消息和原因创建一个新的实例。
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}