package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 14:42
 * @description:
 */
public class ThreadDemo2 {

    public static class MyRunnable implements Runnable {
        private boolean isQuit = false;

        @Override
        public void run() {
            while (!isQuit) {
                System.out.println(Thread.currentThread().getName() + "别管我,我要转账!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "差点被开除了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "李四");
        thread.start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "那是骗子,不要转账");
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        myRunnable.isQuit = false;
    }
}
