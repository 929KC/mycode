package com.bit.string;

public class Test {
    public static void main(String[] args) {
        String s = "";
        for (int i = 0;i<10_000;i++) {
            s+= i;
        }
        System.out.println(s);
    }
}
