package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 11:32
 * @description:
 */
public class ObjectLock {
    private static  Object objectLock = new Object();

    public static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (objectLock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        }
    }

    public static class ThreadB implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(200);
        new Thread(new ThreadB()).start();
    }
}
