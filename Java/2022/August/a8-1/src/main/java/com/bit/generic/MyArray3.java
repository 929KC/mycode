package com.bit.generic;

public class MyArray3 <T>{//此处的泛型变量可以任意写,最好是有意义,T为type的简写
    private T  val;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public static void main(String[] args) {
        MyArray3<String> m = new MyArray3();//<String> 设置val的类型为String
        m.setVal("hello");
        System.out.println(m.getVal());
    }
}
