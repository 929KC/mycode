package org.example.bit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestDemo {
    @MyTest
    public void test1() {
        System.out.println("test1");
    }
    @MyTest
    public void test2() {
        System.out.println("test2");
    }
    @MyTest
    public void test3() {
        System.out.println("test3");
    }
    @MyTest
    public void test4() {
        System.out.println("test4");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestDemo t = new TestDemo();
        //启动程序
        //1.得到TestDemo对象
        Class<TestDemo> testDemoClass = TestDemo.class;
        //提取类中的方法
        Method[] declaredMethods = testDemoClass.getDeclaredMethods();
        //触发方法
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(t);
            }
        }
    }
}
