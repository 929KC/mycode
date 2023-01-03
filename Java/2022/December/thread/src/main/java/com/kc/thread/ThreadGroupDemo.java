package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 9:05
 * @description:
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程的线程组:"+Thread.currentThread().getThreadGroup());
                System.out.println("当前线程的名字:"+Thread.currentThread().getName());
                System.out.println("当前线程的引用:"+Thread.currentThread());
            }
        });
       thread.start();
        System.out.println("mai线程的名字:"+ Thread.currentThread().getName());
        System.out.println("main线程组的名字:"+Thread.currentThread().getThreadGroup());
        System.out.println("线程的优先级:"+thread.getPriority());
        thread.setPriority(10);
        System.out.println(thread);
    }
}
