package com.kc.homework;

public class Demo {
    public static void main(String[] args) {
        int i = 0;
        Object l = 0;
        Integer j = new Integer(0);
        System.out.println(i==j);//j在==比较时会自动插箱
        System.out.println(j.equals(i));//
        System.out.println(j.intValue());
    }
}
