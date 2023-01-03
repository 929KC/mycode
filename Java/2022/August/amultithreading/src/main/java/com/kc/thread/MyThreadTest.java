package com.kc.thread;

/**
 * 实例变量不共享情况
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        t1.start();
        MyThread t2 = new MyThread("t2");
        t2.start();

        MyThread t3 = new MyThread("t3");
        t3.start();
    }
}
