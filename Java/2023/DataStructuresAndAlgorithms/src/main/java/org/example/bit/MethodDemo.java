package org.example.bit;

import org.example.Functional.model.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.反射第一步:获取这个类的Class对象
        Class<User> userClass = User.class;
        //获取类的成员方法
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " "+method.getParameterCount()
            +method.getReturnType());
        }
        //获取某个对象方法
        Method pr = userClass.getDeclaredMethod("pr",String.class);
        System.out.println(pr.getName() + " "+pr.getParameterCount()+" "
                +pr.getReturnType());
        User user = new User();
        pr.setAccessible(true);
        //调用方法,用user对象
        Object invoke = pr.invoke(user,"java");
        System.out.println(invoke);
    }
}
