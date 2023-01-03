package com.bit.java.thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:13
 */

public class JoinThread {
    public static void main(String[] args) {
        System.out.println("begin");
        Thread t=new Thread(new Mythread3());
        t.start();
        try {
            //合并线程
            t.join();//将t合并到当前线程中main,t线程结束后才执行main线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

class Mythread3 implements Runnable{
    @Override
    public void run() {
    for (int i=0;i<100;i++){
        System.out.println(Thread.currentThread().getName()+i);
    }
    }
}

