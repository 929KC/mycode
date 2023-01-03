package com.bit.java.thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:01
 */

/**
 * 了解线程优先级
 */
public class ThreadText {
    public static void main(String[] args) {
        System.out.println("最高优先级："+Thread.MAX_PRIORITY);
        System.out.println("最高优先级："+Thread.MIN_PRIORITY);
        System.out.println("最高优先级："+Thread.NORM_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
        Thread t=new Thread(new Mythread());
        t.start();

    }
}

class Mythread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getPriority());
    }
}
