package com.bit.thread;

public class PrintDemo2 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0;i<10;i++) {
            Thread t1 = new Thread(()->{
                System.out.print("A");
            });
            Thread t2 = new Thread(()->{
                System.out.print("B");
            });
            Thread t3 = new Thread(()->{
                System.out.print("C");
            });
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            System.out.println("");
        }
    }
}
