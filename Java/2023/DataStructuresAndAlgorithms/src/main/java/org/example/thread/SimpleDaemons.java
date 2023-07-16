package org.example.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements  Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" " + this);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //main为非后台线程
        int i=0;
        for (i=0;i<100;i++) {
            Thread th = new Thread(new SimpleDaemons());
            th.setDaemon(true);//设置为后台线程
            th.start();
        }
        System.out.println("All daemons started");
        Thread.sleep(10000);
    }
}
