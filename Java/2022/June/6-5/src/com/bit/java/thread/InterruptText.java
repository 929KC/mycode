package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 15:02
 */

import static java.lang.Thread.sleep;

/**
 * 终止线程睡眠
 */
public class InterruptText {
    public static void main(String[] args) throws InterruptedException {
        Mythread4 m = new Mythread4();
        Thread t = new Thread(m);
        Thread.sleep(5000);
        System.out.println("begin");
        t.start();
        t.interrupt();

    }
}

class Mythread4 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":end");
        try {
            sleep(60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

