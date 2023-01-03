package com.bit.generic;

public class Info <T>{
    private  T age ;

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Info<String> i1 = new Info<>();
        Info<Object> i2 = new Info<>();
        i1.setAge("12");
        fun(i1);
        i2.setAge(12);
        fun(i2);

    }

    public  static  void fun(Info<? super String> temp){
        System.out.println(temp.getAge());
    }
}
