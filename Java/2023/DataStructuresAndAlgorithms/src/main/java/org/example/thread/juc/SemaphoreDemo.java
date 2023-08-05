package org.example.thread.juc;


import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                System.out.println("申请资源");
                semaphore.acquire();
                System.out.println("我获取到资源");
                Thread.sleep(1000);
                System.out.println("我释放资源了");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i <2;i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
