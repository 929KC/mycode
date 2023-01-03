package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 14:23
 * @description:
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + "我还活着!");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我即将死去!");
            System.out.println(Thread.currentThread().isAlive());
        });
        System.out.println( Thread.currentThread().getName()+"id:"+thread.getId());
        System.out.println( Thread.currentThread().getName()+"名称:"+thread.getName());
        System.out.println( Thread.currentThread().getName()+"状态:"+thread.getState());
        System.out.println( Thread.currentThread().getName()+"优先级:"+thread.getPriority());
        System.out.println( Thread.currentThread().getName()+"后台线程:"+thread.isDaemon());
        System.out.println( Thread.currentThread().getName()+"是否存活:"+thread.isAlive());
        System.out.println( Thread.currentThread().getName()+"是否中断:"+thread.isInterrupted());
        thread.start();
    }
}
