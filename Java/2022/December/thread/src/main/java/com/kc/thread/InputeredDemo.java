package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 16:51
 * @description:
 */
public class InputeredDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Hello World");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                   // e.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
