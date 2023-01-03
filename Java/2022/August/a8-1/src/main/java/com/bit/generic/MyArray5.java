package com.bit.generic;

public class MyArray5 <T,V> {
     private  T type;
     private V value;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        MyArray5<Integer,String> m =new MyArray5<>();
        m.setType(1);
        m.setValue("tom");
        System.out.println(m.getType()+","+m.getValue());
    }
}
