package com.bit.spring.bean;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 09:17
 */

public class Teacher {
    private  String name;
    private int age;

    public Teacher() {
        System.out.println("第一步构造器执行");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步调用set方法");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void initMethod(){
        System.out.println("第三步初始化");
    }

    public void destoryMethod(){
        System.out.println("第五步销毁对象");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
