package org.example.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockFairnessDemo {
    private static Lock fairLock = new ReentrantLock(true); // 公平锁
    private static Lock nonFairLock = new ReentrantLock(); // 非公平锁

    public static void main(String[] args) {
        Runnable fairTask = () -> {
            fairLock.lock();
            try {
                System.out.println("Fair lock: Thread " + Thread.currentThread().getId() + " acquired the lock.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();
            }
        };

        Runnable nonFairTask = () -> {
            nonFairLock.lock();
            try {
                System.out.println("Non-fair lock: Thread " + Thread.currentThread().getId() + " acquired the lock.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                nonFairLock.unlock();
            }
        };

        // 使用公平锁执行任务
        for (int i = 0; i < 5; i++) {
            new Thread(fairTask).start();
        }

        try {
            Thread.sleep(10000); // 等待2秒，以确保公平锁的线程先运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------------");

        // 使用非公平锁执行任务
        for (int i = 0; i < 5; i++) {
            new Thread(nonFairTask).start();
        }
    }
}
