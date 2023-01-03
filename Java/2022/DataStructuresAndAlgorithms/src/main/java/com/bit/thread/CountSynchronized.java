package com.bit.thread;

/**
 * 锁具有独占性,如果当前锁没人加,则枷锁成功,否则阻塞等待
 * 原子最小的单位
 * synchronized将不是原子操作的指令进行打包成原子
 *
 */
/**
 * 可重入锁:加锁2次不会产生死锁
 * 不可重入锁:加锁2次会产生死锁
 */
/**
 * 可重入锁的实现要点:
 * 1.让锁里持有线程对象,记录是谁加了锁
 * 2.维护一个计数器,用来衡量啥时候真加锁,啥时候真解锁,啥时候直接放行
 */

/**
 * synchronized的作用
 * 1.修饰普通方法,锁对象相当于是this
 * 2.修饰代码块,锁对象在this()指定
 * 3.修饰静态方法,锁对象相当于类对象
 *
 */
public class CountSynchronized {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new  Counter();
        //for循环并发,函数串行
        Thread t1 = new Thread(()->{
            for (int i=0;i<50000;i++) {
                c.increase();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i=0;i<50000;i++) {
                c.increase();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.count);
    }
}
