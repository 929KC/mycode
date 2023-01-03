package com.bit.thread;

public class Thread6 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
                System.out.println("2");
        });
        t.start();
        System.out.println("1");
    }
}
