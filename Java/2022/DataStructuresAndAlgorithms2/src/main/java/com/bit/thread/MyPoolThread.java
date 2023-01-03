package com.bit.thread;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyPoolThread {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    public MyPoolThread(int m){
        // 在构造方法中, 创建出 M 个线程. 负责完成工作.
        for (int i = 0;i<m;i++) {
            Thread t = new Thread(()->{
               while (true) {
                   try {
                       Runnable take = queue.take();
                       take.run();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
            t.start();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyPoolThread mpt = new MyPoolThread(10);
        for (int i =0;i<10;i++) {
            int takeId = i;
            mpt.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行当前的任务:"+takeId+"当前的线程"+Thread.currentThread().getName());
                }
            });
        }
    }
}
