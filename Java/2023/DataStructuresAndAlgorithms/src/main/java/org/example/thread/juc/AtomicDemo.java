package org.example.thread.juc;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private static AtomicInteger counter = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <5000;i++) {
                counter.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <5000;i++) {
                counter.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
