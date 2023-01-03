package com.bit.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
    @Test
    public void test() throws ClassNotFoundException {
        //获取class对象的三种方式
        Class<?> aClass = Class.forName("com.bit.reflect.Student");
        System.out.println(aClass);
        //使用类名.class
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        //使用类对象的getClass()方法
        Student s = new Student();
        System.out.println(s.getClass());
    }

    @Test
    public void  TestReflectNewInstance() throws InstantiationException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
        System.out.println(student);
        student.study();
    }

    @Test
    public  void reflectPrivateConstructor() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Student> studentClass = Student.class;
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(int.class, String.class, String.class);
        declaredConstructor.setAccessible(true);
        Student student = declaredConstructor.newInstance(19,"叶秋涵","湖南");
        System.out.println(student);
    }

    @Test
    public void  reflectPrivateField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        Field age = studentClass.getDeclaredField("age");
        age.setAccessible(true);
        Student student = studentClass.newInstance();
        age.set(student,12);
        Integer getAge= (Integer) age.get(student);
        System.out.println(getAge);
    }

    @Test
    public  void reflectPrivateMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Student> studentClass = Student.class;
        Method method = studentClass.getDeclaredMethod("play",String.class);
        System.out.println(method.getName());
        method.setAccessible(true);
        Student student = studentClass.newInstance();
        Object Student;
     method.invoke(student,"叶秋涵");
    }
}
