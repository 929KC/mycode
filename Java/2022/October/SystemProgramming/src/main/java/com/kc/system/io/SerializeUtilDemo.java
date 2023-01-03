package com.kc.system.io;

import java.io.IOException;

public class SerializeUtilDemo {
    public static void main(String[] args) throws IOException {
        Student s = new Student();
        s.setName("叶秋涵");
        s.setAge(18);
        s.setAddress("北海");
        s.setSchool("哔哩哔哩");
        SerializeUtil.saveObject(s);
        System.out.println("序列化完成了");
        System.out.println("-----");
        Student student = (Student)SerializeUtil.readObject();
        System.out.println(student);
    }
}
