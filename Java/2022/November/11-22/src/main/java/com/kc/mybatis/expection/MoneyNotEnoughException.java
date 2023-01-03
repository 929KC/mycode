package com.kc.mybatis.expection;

/**
 * @author 929KC
 * @date 2022/11/21 19:56
 * @description: 余额不足异常
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
