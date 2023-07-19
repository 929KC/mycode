package org.example.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator{
    private static Object ob = new Object();
    private Lock locks = new ReentrantLock();
    private int currentEvenValue = 0;

    /**
     *生产偶数
     * 当在对象上调用其任意synchronized方法的时候，此对象都被加锁，
     * 这时该对象上的其他synchronized方法只有等到前一个方
     * 法调用完毕并释放了锁之后才能被调用。
     * @return
     */
  /*  @Override
    public synchronized int next() {
        synchronized (ob){
            ++currentEvenValue;
            ++currentEvenValue;
      }
    return currentEvenValue;
    }*/

    @Override
    public  int next() {
        locks.lock();
           try {
               ++currentEvenValue;
               ++currentEvenValue;
               return currentEvenValue;
           }finally {
               locks.unlock();
           }
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
