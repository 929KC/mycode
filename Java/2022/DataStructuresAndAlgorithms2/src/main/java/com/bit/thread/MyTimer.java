package com.bit.thread;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 锁范围扩大的原因
 */
public class MyTimer {
    private BlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    private Object locker = new Object();

    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        MyTask take = queue.take();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= take.getTime()) {
                            take.getRunnable().run();
                        } else {
                            //还没到点继续入队
                            queue.put(take);
                            //继续等待
                            // synchronized (locker) {
                            locker.wait(take.getTime() - curTime);
                            //}
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void schedule(Runnable task, long after) throws InterruptedException {
        MyTask m = new MyTask(task, after);
        queue.put(m);
        synchronized (locker) {
            //唤醒
            locker.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到1!");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到2!");
            }
        }, 4000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间到3!");
            }
        }, 5000);
        System.out.println("开始计时");
    }
}
