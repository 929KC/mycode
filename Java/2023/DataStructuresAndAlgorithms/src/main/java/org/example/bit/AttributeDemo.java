package org.example.bit;

import org.example.Functional.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AttributeDemo {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        //1.反射第一步:获取这个类的Class对象
        Class<User> userClass = User.class;
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName()+"-->"+field.getType());
        }
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+"-->"+declaredField.getType());
        }
        //定位某个变量
        Field age = userClass.getField("age");
        Field username = userClass.getDeclaredField("username");
        Field password = userClass.getDeclaredField("password");
        User user = new User();
        //设置私有变量的访问
        username.setAccessible(true);
        password.setAccessible(true);
        //赋值
        username.set(user,"sdf");
        password.set(user,"ss12");
        age.set(user,90);
        System.out.println(user);
        //取值
        String o = (String)username.get(user);
        System.out.println(o);
    }
}
