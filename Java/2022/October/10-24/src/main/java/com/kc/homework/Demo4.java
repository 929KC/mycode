package com.kc.homework;

public class Demo4 {
    public static void main(String[] args) {
        byte b1= 1 ,b2 = 2,b3,b6;
        final byte b4 = 4,b5 = 6;
        b6 = b4+b5;
        b3 = (byte)(b1+b2);
        System.out.println(b3+b6);
        String str1 = "hello";
        String str2 = "he"+new String("llo");
        System.out.println(str1 == str2);
    }
}
