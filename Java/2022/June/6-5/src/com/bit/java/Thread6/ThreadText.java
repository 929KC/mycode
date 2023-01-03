package com.bit.java.Thread6;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 21:32
 */

import java.util.ArrayList;
import java.util.List;

/**
 * o.wait方法的作用：让正在o对象上获取的线程进入等待状态,并且释放掉该线程所占用的锁
 * o.notify方法的作用：让正在o对象上等待的线程唤醒,只是通知,不会是方法该线程的锁
 */
public class ThreadText {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
       Thread p=new Thread(new Producer(list));
       Thread c=new Thread(new Consumer(list));
       p.setName("生产者：");
       c.setName("消费者：");
       p.start();
       c.start();
    }
}
