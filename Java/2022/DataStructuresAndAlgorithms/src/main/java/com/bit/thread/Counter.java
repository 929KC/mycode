package com.bit.thread;

/**
 * 加锁就是让并发执行操作转发换串行
 * 锁对象是来控制线程互斥
 */
public class Counter {
    public  static Object obj = new Object();
    public static int count ;
    public synchronized void increase() {
        count++;
    }
//    public synchronized void increase() {
//        synchronized(this){//任何对象都可以作为锁对象 两个线程必须锁同一个对象才有锁竞争,锁不同对象则无
//            count++;
//        }
//    }

//    public void increase() {
//            count++;
//    }
}
