package com.bit.thread;

public class StartAndRun {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0;i<3;i++) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.run();
    }
}
