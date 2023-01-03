package com.bit.java.deadlock;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 19:37
 */

/**
 * 死锁
 */
public class Text {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
       Thread t1=new Mythread1(o1,o2);
       Thread t2=new Mythread2(o1,o2);
       t1.start();
       t2.start();
    }
}
