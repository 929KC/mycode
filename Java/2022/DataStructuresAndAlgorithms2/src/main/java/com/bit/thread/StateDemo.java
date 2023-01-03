package com.bit.thread;

public class StateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i =0;i<50;i++) {
                System.out.println("Hello World");
            }

        });
        System.out.println(t.getState());
        t.start();
        Thread.sleep(5);
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }
}
