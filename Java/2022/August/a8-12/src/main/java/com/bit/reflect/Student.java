package com.bit.reflect;

public class Student {
        private  int age;
        private String name;
        private String address;

    public Student() {
    }

    public Student(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

     public void study(){
        System.out.println("好好学习");
    }

    private void play( String name){
        System.out.println(name+"playGame");
    }
}
