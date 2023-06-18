package com.kc.cloud_takeaway.exception;

import com.kc.cloud_takeaway.common.ErrorCode;

public class BusinessException extends RuntimeException{
    private final int code;

    public BusinessException(int code) {
        this.code = code;
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
