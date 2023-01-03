package com.bit.java.thread5;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 20:10
 */

public class Mythread extends Thread {
    @Override
    public void run() {
            int i=0;
           while(true){
               try {
                   sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"分支线程备份数据"+i);
           }

    }
}
