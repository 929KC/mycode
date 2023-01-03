package com.bit.thread;

/**
 * interrupt()；
 * 状态1:线程运行状态将标志位设置为true
 * 状态2:线程处于阻塞状态会触发InterruptedException
 */
public class Interruped {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("Hello World");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("t 线程执行完了");
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("设置让 t 线程结束!");
    }
}
