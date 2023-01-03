package com.bit.thread;

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i =0;i<10;i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello World");
            }
        });
        System.out.println("main线程join之前:");
        t.start();
        t.join(1000);
        System.out.println("main线程join之后:");

    }
}
