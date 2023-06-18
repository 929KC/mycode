package com.kc.cloud_takeaway.common;

/**
 * 返回工具类
 *
 * @param <T>
 */
public class ResultUtils<T> {


    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(1, "ok", data);
    }

    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    public static BaseResponse error(ErrorCode errorCodee, String message) {
        return new BaseResponse<>(errorCodee.getCode(), null, message);
    }
}
