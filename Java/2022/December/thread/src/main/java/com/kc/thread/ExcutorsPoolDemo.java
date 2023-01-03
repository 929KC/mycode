package com.kc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 929KC
 * @date 2022/12/18 16:25
 * @description:
 */
public class ExcutorsPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        executorService3.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });
    }
}
