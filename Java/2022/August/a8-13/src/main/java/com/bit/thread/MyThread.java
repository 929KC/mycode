package com.bit.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("thread");
        }
    }
}
