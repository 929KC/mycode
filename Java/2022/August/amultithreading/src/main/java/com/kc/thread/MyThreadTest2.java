package com.kc.thread;

public class MyThreadTest2 {
    public static void main(String[] args) {
        MyThread2 m = new MyThread2();
        Thread t1 = new Thread(m,"t1");
        t1.start();
        Thread t2 = new Thread(m,"t2");
        t2.start();
        Thread  t3 = new Thread(m,"t3");
        t3.start();
        Thread  t4 = new Thread(m,"t4");
        t4.start();
        Thread t5 = new Thread(m,"t5");
        t5.start();
    }
}
