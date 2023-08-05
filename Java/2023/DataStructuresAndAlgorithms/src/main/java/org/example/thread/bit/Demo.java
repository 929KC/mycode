package org.example.thread.bit;

public class Demo {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },"thread2");
        t.start();
        t.run();
    }
}
