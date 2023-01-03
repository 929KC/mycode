package com.bit.generic;

public class MyArray {
  public   Object []  arr = new Object[10];

    public void setPos(int pos,Object  val){
        this.arr[pos] = val;
    }

    public Object getValue(int pos) {
        return  arr[pos];
    }

    public static void main(String[] args) {
        MyArray m = new MyArray();
        m.setPos(0,12);
        m.setPos(1,"hello");
        Integer value = (Integer) m.getValue(0);
        System.out.println(value);
        String value1 =(String) m.getValue(1);
        System.out.println(value1);
    }
}
