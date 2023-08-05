package org.example.thread.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //构造 CountDownLatch 实例, 初始化 10 表示有 10 个任务需要完成
        CountDownLatch latch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"已经到了");
                latch.countDown();
            }
        };
        for (int i = 0; i <10;i++) {
            new Thread(runnable).start();
        }
        latch.await();
        System.out.println("比赛结束");
    }
}
