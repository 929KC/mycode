package com.kc.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 929KC
 * @date 2022/12/18 14:50
 * @description:
 */
public class MyTimer {
    private BlockingQueue<MyTask> bockedQueue = new LinkedBlockingQueue();
    private static Object loker = new Object();

    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (loker) {
                        MyTask myTask = bockedQueue.take();
                        long current = System.currentTimeMillis();
                        if (current >= myTask.getTime()) {
                            myTask.getRunnable().run();
                        } else {
                            bockedQueue.put(myTask);
                            loker.wait(myTask.getTime() - current);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void schedule(Runnable runnable, long time) throws InterruptedException {
        MyTask myTask = new MyTask(runnable, time);
        bockedQueue.put(myTask);
        synchronized (loker) {
            loker.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了!1111");
            }
        }, 1000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了!2222");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床了!3333");
            }
        }, 3000);
    }
}
