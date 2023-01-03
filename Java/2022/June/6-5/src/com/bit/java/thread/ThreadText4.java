package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 14:10
 */

public class ThreadText4 {

    public static void main(String[] args) {
        Mythread2 m = new Mythread2();
//        System.out.println(m.getName());
//        m.setName("第一个线程");
//        System.out.println(m.getName());
        Thread mainName = Thread.currentThread();
        System.out.println(mainName);
        m.start();
    }
}

class Mythread2 extends Thread {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 0; i < 6; i++) {
            System.out.println(t.getName() + "分支线程->" + i);
        }
    }
}
