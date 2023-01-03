package com.bit.spring5.bean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 19:57
 */

public class Student {
    private int age;
    private String name;
    private  String school;

    public Student(int age, String name, String school) {
        this.age = age;
        this.name = name;
        this.school = school;
    }
    public void print(){
        System.out.println("我是"+name+"今年"+age+"在"+school+"学习");
    }

}
