package org.example.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("启动");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("等待的过程中被中断");
                return;
            }
            try {
                System.out.println("t1获得了锁");
            }finally {
                lock.unlock();
            }
        },"t1");
        lock.lock();
        System.out.println("获得了锁");
        t1.start();
        try {
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("t1执行被打断");
        } finally {
            lock.unlock();
        }
    }
}
