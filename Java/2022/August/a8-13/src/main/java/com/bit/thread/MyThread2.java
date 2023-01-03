package com.bit.thread;

public class MyThread2  implements Runnable {
    @Override
    public void run() {
    while (true) {
        System.out.println("thread");
    }
    }
}
