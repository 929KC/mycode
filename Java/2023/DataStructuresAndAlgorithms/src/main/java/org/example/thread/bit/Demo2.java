package org.example.thread.bit;

import org.example.thread.PairValuesNotEqualException;

public class Demo2 {
    private final static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(90000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("hehehe");
            }
        },"t2");
        t2.start();
    }
}
