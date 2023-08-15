package org.example.bit;

import java.util.Arrays;

public class AnnotationTest2 {
    public static void main(String[] args) {
        //1.得到class对象
        Class<Demo> demoClass = Demo.class;
        //2.判断类上是否包含注解
        if (demoClass.isAnnotationPresent(MyTest2.class)) {
            MyTest2 myTest2 = demoClass.getDeclaredAnnotation(MyTest2.class);
            System.out.println(myTest2.value());
            System.out.println(myTest2.name());
            System.out.println(myTest2.flag());
            System.out.println(Arrays.toString(myTest2.str()));
        }
    }
}
