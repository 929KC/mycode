package com.bit.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 必须实现Invocationhandler，完成代理类要做的功能，调用目标方法,功能增强
 */
public class MyIIvCationHandler implements InvocationHandler {
        Object target = null;

    public MyIIvCationHandler(Object target) {
        this.target = target;
    }
    //该方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           Object ret = null;
           ret = method.invoke(target, args);
        if (ret!=null) {
            float price = (float) ret;
            price +=90.f;
            ret = price;
        }
        return ret;
    }
}
