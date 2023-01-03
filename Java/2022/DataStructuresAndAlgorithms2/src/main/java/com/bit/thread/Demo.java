package com.bit.thread;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "a");
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "b");
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "c");
        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
        t1.join();
    }
}
