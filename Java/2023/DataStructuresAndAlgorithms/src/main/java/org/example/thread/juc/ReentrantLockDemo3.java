package org.example.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo3 {
    private static Lock lock = new ReentrantLock();
    private static Condition waitCigaretteQueue = lock.newCondition();
    private static Condition waitbreakfastQueue = lock.newCondition();
    private static volatile boolean hasCigrette = false;
    private static volatile boolean hasBreakFast = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            try {
                while (!hasCigrette) {
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("等到了它的烟");
                }

            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                while (!hasBreakFast) {
                    try {
                        waitbreakfastQueue.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("等到了它的早餐");
                }

            }finally {
                lock.unlock();
            }
        }).start();
        Thread.sleep(1000);
        sendBreakFast();
        Thread.sleep(1000);
        sendCigarette();
    }

    private static void sendCigarette() {
        lock.lock();
        try {
            System.out.println("送烟来了");
            hasCigrette = true;
            waitCigaretteQueue.signal();
        }finally {
            lock.unlock();
        }
    }

    private static void sendBreakFast() {
        lock.lock();
        try {
            System.out.println("送早餐来了");
            hasBreakFast = true;
            waitbreakfastQueue.signal();
        }finally {
            lock.unlock();
        }
        
    }
}
