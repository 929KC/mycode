package com.bit.java.thread;

import static java.lang.Thread.sleep;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 15:18
 */

/**
 * stop()方法容易造成数据丢失,合理的终止线程可以使用一个boolean进行标记
 */
public class StopThread {
    public static void main(String[] args) throws InterruptedException {
//        Mythread5 m = new Mythread5();
//        Thread t = new Thread(m);
//        t.start();
//        Thread.sleep(5 * 1000);
//        t.stop();
        Mythread6 m = new Mythread6();
        Thread t = new Thread(m);
        t.start();
        Thread.sleep(5 * 1000);
        m.flag = false;
    }
}

class Mythread5 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Mythread6 implements Runnable {
    boolean flag = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            if (flag) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                return;
            }
        }
    }
}
