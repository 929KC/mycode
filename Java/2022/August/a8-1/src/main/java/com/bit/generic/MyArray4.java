package com.bit.generic;

public class MyArray4 {
    private String val;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public static void main(String[] args) {
        MyArray3 m = new MyArray3();//<String> 设置val的类型为String
        m.setVal("hello");
        System.out.println(m.getVal());
    }
}
