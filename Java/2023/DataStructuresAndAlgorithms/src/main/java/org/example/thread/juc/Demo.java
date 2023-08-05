package org.example.thread.juc;

import java.util.Hashtable;

public class Demo {
    static class Result{
        public int sum  =0;
        private Object lock = new Object();
    }

    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        Hashtable hashtable = new Hashtable();

        Thread t = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i <=1000;i++) {
                sum+=i;
            }
            synchronized (result.lock) {
                result.sum=sum;
                result.lock.notify();
            }
        });
        t.start();
        synchronized (result.lock) {
            while (result.sum==0) {
                result.lock.wait();
            }
            System.out.println(result.sum);
        }

    }
}
