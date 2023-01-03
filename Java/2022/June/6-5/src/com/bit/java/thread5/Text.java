package com.bit.java.thread5;

import com.bit.java.deadlock.Mythread1;

import static java.lang.Thread.sleep;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 20:11
 */

public class Text {
    public static void main(String[] args) {
        Thread t=new Mythread();
        t.setName("备份数据库");
        t.setDaemon(true);//设置为守护线程
        t.start();
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"main"+i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
