package org.example.thread.bit;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": 我还活着");
                    Thread.sleep(1 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": 我即将死去");
        });
        System.out.println(Thread.currentThread().getName()
                + ": ID: " + thread.getId());
        System.out.println(Thread.currentThread().getName()
                + ": 名称: " + thread.getName());
        System.out.println(Thread.currentThread().getName() + ": 状态: " + thread.getState());
        System.out.println(Thread.currentThread().getName()
                + ": 优先级: " + thread.getPriority());
        System.out.println(Thread.currentThread().getName()
                + ": 后台线程: " + thread.isDaemon());
        System.out.println(Thread.currentThread().getName()
                + ": 活着: " + thread.isAlive());
        System.out.println(Thread.currentThread().getName()
                + ": 被中断: " + thread.isInterrupted());
        thread.start();
        while (thread.isAlive()) {
        }
        System.out.println(Thread.currentThread().getName() + ": 状态: " + thread.getState());
    }
}