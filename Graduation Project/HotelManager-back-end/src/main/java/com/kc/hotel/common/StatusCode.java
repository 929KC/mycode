package com.kc.hotel.common;


public enum StatusCode {

    COMMON_SUCCESS(ConstantCode.SUCCESS, "成功。"),
    COMMON_FAIL(ConstantCode.FAIL, "失败")
    ;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    StatusCode() {
    }

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
