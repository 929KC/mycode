package com.bit.proxy;

import com.bit.dynamic.MyIIvCationHandler;
import com.bit.dynamic.UsbFactory;
import com.bit.dynamic.UsbShell;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    @Test
    public  void testStaticProxy(){
        TaoBao t = new TaoBao();
        float v = t.shellUsb();
        System.out.println(v);
    }

    @Test
    public  void  testDynamicProxy(){
        //创建目标对象
        UsbShell u = new UsbFactory();
        //创建InvocationHandler
        InvocationHandler handler = new MyIIvCationHandler(u);
        //创建代理对象
        UsbShell o = (UsbShell)Proxy.newProxyInstance(u.getClass().getClassLoader(), u.getClass().getInterfaces(),
                handler);
        System.out.println(o.shellUsb());

    }
}
