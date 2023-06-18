package com.kc.cloud_takeaway.common;


import lombok.Data;
import java.io.Serializable;

/**
 * 通用返回类
 * @param <T>
 */
@Data
public class BaseResponse<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(int code, T data) {
        this(code, null, data);
    }
    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(), errorCode.getMessage(),null);
    }

}
