package org.example.thread.bit;

public class ThreadStateTransfer {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
            }
        }, "李四");
        System.out.println(t.getName() + ": " + t.getState());
        t.start();
        //使用 isAlive 方法判定线程的存活状态
        while (t.isAlive()) {
            System.out.println(t.getName() + ": " + t.getState());
        }
        System.out.println(t.getName() + ": " + t.getState());
    }
}