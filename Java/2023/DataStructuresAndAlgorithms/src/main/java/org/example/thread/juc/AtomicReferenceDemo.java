package org.example.thread.juc;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static AtomicReference<String> ref = new AtomicReference<String>("A");

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start ...");
        String prev = ref.get();
        update();
        Thread.sleep(1000);
        System.out.println("change A->Z "+ref.compareAndSet(prev, "Z"));
    }

    private static void update() throws InterruptedException {
        new Thread(() -> {
            System.out.println("change A-B");
            ref.compareAndSet(ref.get(), "B");
        },"t1").start();
        new Thread(() -> {
            System.out.println("change B-A");
            ref.compareAndSet(ref.get(), "A");
        },"t2").start();
    }
}
