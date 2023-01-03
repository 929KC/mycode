package com.kc.thread;

public class MyThreadTest3 {
    public static void main(String[] args) {
        MyThread3 m = new MyThread3();
        Thread t1 = new Thread( m,"t1");
        Thread t2 = new Thread(m,"t2");
        Thread t3 = new Thread(m,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
