package com.bit.thread;

public class Thread1 {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();
        while (true) {
            System.out.println("main");
        }
    }
}
