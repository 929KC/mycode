package org.example.bit;

import org.example.Functional.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorsDemo2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1.反射第一步:获取这个类的Class对象
        Class<User> userClass = User.class;
        Constructor<User> declaredConstructor1 = userClass.getDeclaredConstructor(String.class, String.class);
        //设置禁止访问权限
         declaredConstructor1.setAccessible(true);
        User user = declaredConstructor1.newInstance( "sdf","211");
        System.out.println(user.toString());
    }
}
