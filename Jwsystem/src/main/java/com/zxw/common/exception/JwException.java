package com.zxw.common.exception;

public class JwException extends RuntimeException {
    private final Object errorCode;

    public JwException(Object errorCode) {
        super("Error Code: " + errorCode);
        this.errorCode =  errorCode;
    }

    public Object getErrorCode() {
        return errorCode;
    }
}