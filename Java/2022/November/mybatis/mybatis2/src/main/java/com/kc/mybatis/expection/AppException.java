package com.kc.mybatis.expection;

/**
 * @author 929KC
 * @date 2022/11/21 19:59
 * @description:
 */
public class AppException extends Exception{
    public AppException() {
    }
    public AppException(String message) {
        super(message);
    }
}
