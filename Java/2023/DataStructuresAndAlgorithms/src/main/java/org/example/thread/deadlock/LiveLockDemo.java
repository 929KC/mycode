package org.example.thread.deadlock;

public class LiveLockDemo {
    private static int count = 10;

    public static void main(String[] args) {

        new Thread(() -> {
            // 期望减到 0 退出循环
            while (count > 0) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                System.out.println(count);
            }
        }, "t1").start();
        new Thread(() -> {
            // 期望超过 20 退出循环
            while (count < 20) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                System.out.println(count);
            }
        }, "t2").start();
    }
}
