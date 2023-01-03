package com.kc.thread2;


public class LoginServletTest {
    public static void main(String[] args) {
        ALogin  a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
