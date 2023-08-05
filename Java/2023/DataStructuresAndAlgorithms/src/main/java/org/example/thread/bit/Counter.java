package org.example.thread.bit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private static Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter.increase();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
