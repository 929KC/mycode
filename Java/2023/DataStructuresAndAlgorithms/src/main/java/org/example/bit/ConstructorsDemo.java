package org.example.bit;

import org.example.Functional.model.User;

import java.lang.reflect.Constructor;

public class ConstructorsDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        //1.反射第一步:获取这个类的Class对象
        Class<User> userClass = User.class;
        //获取类的无参构造
        Constructor<User> declaredConstructor = userClass.getDeclaredConstructor();
        //设置禁止访问权限
        declaredConstructor.setAccessible(true);
        //得到类名称和参数个数
        System.out.println(declaredConstructor.getName()+"->"+declaredConstructor.getParameterCount());
        //获取有参构造
        Constructor<User> declaredConstructor1 = userClass.getConstructor(String.class, String.class);
        //设置禁止访问权限
        declaredConstructor1.setAccessible(true);
        //得到类名称和参数个数
        System.out.println(declaredConstructor1.getName()+"->"+declaredConstructor1.getParameterCount());

        Constructor<?>[] constructors = userClass.getConstructors();
        Constructor<?>[] declaredConstructors = userClass.getDeclaredConstructors();
        System.out.println(constructors[1]);
        System.out.println(constructors[0]);
        System.out.println(declaredConstructors[1]);
        System.out.println(declaredConstructors[0]);
    }
}
