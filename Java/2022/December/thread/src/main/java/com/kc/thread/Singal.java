package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/9 19:07
 * @description:
 */
public class Singal {
    public static volatile int singal = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (singal < 5) {
                if (singal % 2 == 0) {
                    System.out.println("ThreadA:" + singal);
                    synchronized (this) {
                        singal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (singal < 5) {
                if (singal % 2 == 1) {
                    System.out.println("ThreadB:" + singal);
                    synchronized (this) {
                        singal++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(2000);
        new Thread(new ThreadB()).start();
    }
}
