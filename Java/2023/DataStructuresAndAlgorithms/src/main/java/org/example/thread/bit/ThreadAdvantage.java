package org.example.thread.bit;

public class ThreadAdvantage {
    private static final long count = 10_0000_0000;

    public static void main(String[] args) throws InterruptedException {
        //并发
        concurrency();
        //串行
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t = new Thread(() -> {
            int a = 0;
            for (int i = 0; i < count; i++) {
                a--;
            }
        });
        Thread t2 = new Thread(() -> {
            int b = 0;
            for (int i = 0; i < count; i++) {
                b--;
            }
        });
        t.start();
        t2.start();
        t.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("并发:毫秒:" +(end - start) + "ms");
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a--;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long end = System.currentTimeMillis();
        System.out.println("串行:毫秒:" +(end - start) + "ms");
    }

}
