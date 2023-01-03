package com.bit.abnormal;

/**
    自定义的编译时异常
      1、继承RuntimeException
      2、重写构造器
 */
public class ItheimaAgeIlleagalRuntimeException extends RuntimeException{
    public ItheimaAgeIlleagalRuntimeException() {
    }

    public ItheimaAgeIlleagalRuntimeException(String message) {
        super(message);
    }
}
