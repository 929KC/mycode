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
 * 生产线程
 */
public class Producer implements Runnable {
    private List list;
    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
          synchronized (list){
              if (list.size() >0) {
                  try {
                      list.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              } else {
                  String pro="苹果";
                  list.add(pro);
                  list.notify();
                  System.out.println(Thread.currentThread().getName()+"-->"+pro+"生产了");
              }
          }
        }
    }
}
