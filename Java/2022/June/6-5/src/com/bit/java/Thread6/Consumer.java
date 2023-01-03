package com.bit.java.Thread6;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 21:33
 */

import java.util.List;

/**
 * 消费线程
 */
public class Consumer implements Runnable{
    private List list;
    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {

    while (true){
       synchronized (list){
           if(list.size()==0){
               try {
                   list.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }else{
              String str= (String) list.remove(0);
               System.out.println(Thread.currentThread().getName()+"--->"+str+"消费了");
               list.notify();
           }
       }
    }
    }
}
