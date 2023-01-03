package com.bit.thread;

/**
 * count操作需要三条指令
 * 1.load:从内存中读取数据到CPU寄存器中
 * 2.在CPU寄存器中对count+1
 * 3.将寄存器中的数据写回内存
 * CPU的调度是随机的
 *
 * 线程不安全的原因:
 * 1.抢占式执行
 * 2.多个线程修改同一变量
 * 3.操作不是原子的
 * 4.内存可见性(JVM优化)--->调整代码,保证代码逻辑一致(逻辑等价,效率提高)
 * 5.指令重排序
 */
public class CountDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new  Counter();
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
