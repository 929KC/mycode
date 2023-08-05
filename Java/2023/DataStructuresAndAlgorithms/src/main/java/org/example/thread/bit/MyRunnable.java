package org.example.thread.bit;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
       while (true){
           System.out.println("我是线程" + Thread.currentThread().getId());
           Thread.yield();
       }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }
}
