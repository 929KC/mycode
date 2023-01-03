package com.bit.spring5.bean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 07:38
 */

public class User {
    private int age;
   private String name;
   private  String school;

    public void print(){
        System.out.println("我是"+name+"今年"+age+"在"+school+"学习");
        System.out.println("Hello World");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
