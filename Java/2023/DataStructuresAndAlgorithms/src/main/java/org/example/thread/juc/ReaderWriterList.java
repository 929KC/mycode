package org.example.thread.juc;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ReaderWriterList(int size) {
        this.lockedList = new ArrayList<T>(size);
    }

    public T set(int index, T element) {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            return lockedList.set(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    public T get(int index) {
        T ret = null;
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            if (lock.getReadLockCount() > 1) {
                System.out.println(lock.getReadLockCount());
                return lockedList.get(index);
            }
        } finally {
            readLock.unlock();
        }
        return ret;
    }

}
