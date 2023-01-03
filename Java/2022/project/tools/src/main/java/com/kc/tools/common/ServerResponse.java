package com.kc.tools.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 929KC
 * @date 2022/11/24 8:59
 * @description:
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ServerResponse<T> implements Serializable {
    private  int code;
    private String message;
    private T data;

    public ServerResponse(int code) {
        this.code = code;
    }

    public ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }
    @JsonIgnore
    public boolean isSuccess() {
       return  this.code == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> createSuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createSuccessMessage(String message) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> ServerResponse<T> createSuccessData(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createSuccessData(String message, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),message, data);
    }

    public static <T> ServerResponse<T> createError() {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createError(String errorMessage) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createError(int code, String errorMessage) {
        return new ServerResponse<>(code, errorMessage);
    }
}
