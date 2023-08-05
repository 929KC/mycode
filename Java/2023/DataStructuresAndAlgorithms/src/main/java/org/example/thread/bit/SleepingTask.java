package org.example.thread.bit;

import java.util.concurrent.TimeUnit;
public class SleepingTask implements Runnable {
    private static long count = 10;

    @Override
    public void run() {
        while (count-- > 0) {
            try {
                //Thread.sleep(1000);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("线程名字:" + Thread.currentThread().getName() + " 线程Id:" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SleepingTask());
            t.start();
        }
    }
}
