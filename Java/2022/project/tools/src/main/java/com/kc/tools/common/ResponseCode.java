package com.kc.tools.common;

/**
 * @author 929KC
 * @date 2022/11/24 8:59
 * @description:
 */
public enum ResponseCode {
    /**
     *
     * @author 929KC
     * @date 2022/11/24 2022/11/24
     * @description: 成功
     */
    SUCCESS(1,"SUCCESS"),
    /**
     *
     * @author 929KC
     * @date 2022/11/24 2022/11/24
     * @description: 失败
     */
    ERROR(2,"ERROR");

    private final int code;
    private final  String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
