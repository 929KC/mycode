package com.bit.thread;

public class PrintDemo {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<20;i++) {
            int id = i;
            Thread t = new Thread(()->{
                System.out.println("我是第"+id+"个");
            });
            t.start();
            t.join();
        }
        System.out.println("OK");
    }
}
