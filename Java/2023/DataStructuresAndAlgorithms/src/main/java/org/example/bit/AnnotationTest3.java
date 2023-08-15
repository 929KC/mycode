package org.example.bit;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest3 {

    public static void main(String[] args) throws NoSuchMethodException {
        //1.得到class对象
        Class<Demo> demoClass = Demo.class;
        Method test = demoClass.getDeclaredMethod("test");
        //2.判断方法对象上是否包含注解
        if (test.isAnnotationPresent(MyTest2.class)) {
            MyTest2 myTest2 = test.getDeclaredAnnotation(MyTest2.class);
            System.out.println(myTest2.value());
            System.out.println(myTest2.name());
            System.out.println(myTest2.flag());
            System.out.println(Arrays.toString(myTest2.str()));
        }
    }
}
