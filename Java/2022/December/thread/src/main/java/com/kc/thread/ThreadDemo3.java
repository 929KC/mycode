package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 16:26
 * @description:
 */
public class ThreadDemo3 {
    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "别管我,我要转账!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+"有内鬼,终止交易");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "差点被开除了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2.MyRunnable myRunnable = new ThreadDemo2.MyRunnable();
        Thread thread = new Thread(myRunnable, "李四");
        thread.start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "那是骗子,不要转账");
        thread.interrupt();
    }
}
