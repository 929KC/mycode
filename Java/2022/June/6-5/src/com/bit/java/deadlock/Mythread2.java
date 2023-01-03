package com.bit.java.deadlock;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 19:37
 */

public class Mythread2 extends Thread{
    Object o1;
    Object o2;

    public Mythread2(Object o1,Object o2){
        this.o1=o1;
        this.o2=o2;
    }
    @Override
    public void run() {
        synchronized (o2) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {

            }
        }
    }
}
