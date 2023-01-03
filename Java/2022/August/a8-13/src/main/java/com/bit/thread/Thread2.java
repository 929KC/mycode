package com.bit.thread;

public class Thread2 {
    public static void main(String[] args) {
        MyThread2 m = new MyThread2();
        Thread t =new Thread(m);
        t.start();
        while (true) {
            System.out.println("main");
        }
    }
}
