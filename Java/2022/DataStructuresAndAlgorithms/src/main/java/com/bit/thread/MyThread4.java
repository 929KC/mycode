package com.bit.thread;

/**
 * 守护线程(后台线程):当main等其它前台线程执行完了,此时,即使后台线程没执行完,进程也会退出。
 * 前台线程 :如果main运行完了,前台线程还没完,进程不会退出。
 *
 */
public class MyThread4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello World");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setName("线程1");
        t.setDaemon(true);//设置成守护线程
        t.start();
        System.out.println("我是main线程");
    }
}
