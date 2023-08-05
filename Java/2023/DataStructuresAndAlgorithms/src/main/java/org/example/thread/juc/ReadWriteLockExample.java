package org.example.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int sharedData = 0;
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock readLock = rwLock.readLock();
    private Lock writeLock = rwLock.writeLock();

    public void readData() {
        readLock.lock();
        try {
            System.out.println("Read Thread: Reading data: " + sharedData);
        } finally {
            readLock.unlock();
        }
    }

    public void writeData(int data) {
        writeLock.lock();
        try {
            System.out.println("Write Thread: Writing data: " + data);
            sharedData = data;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();
        // 创建多个读取线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    example.readData();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        // 创建一个写入线程
        new Thread(() -> {
            int data = 1;
            while (true) {
                example.writeData(data);
                data++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
