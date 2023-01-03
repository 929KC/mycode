package com.bit.thread;



/**
 * 阻塞队列
 * 1.线程安全
 * 2.带有阻塞功能
 * (a)如果队列满,继续入队列,入队列操作就会阻塞,直到队列不满,入队列才能完成
 * (b)如果队列空,继续出队列,出队列操作也会阻塞,直到队列不空,出队列才能完成
 */

/**
 * 生产者消费者模式
 */
public class MyBlockingQueue {
    private int []  items = new int [10];
    private int head;
    private int tail;
    private int size;

    public  void put(int elem) throws InterruptedException {
       synchronized (this) {
           //队列满了
           while (size>=items.length) {//反复的判断队列是否已满 ,满了则不能入队只能阻塞
               this.wait();
           }
           items[tail++] = elem;//入队
           if (tail>=items.length) {
               tail = 0;
           }
           size++;
           this.notify();
       }
    }

    public  Integer take() throws InterruptedException {
      synchronized (this) {
          while (size==0) {//反复的判断队列是否为空,空了就不能出队,只能阻塞
              this.wait();
          }
          int ret = items[head++];//出队
          if (head>=items.length) {
              head = 0;
          }
          size--;
          this.notify();
          return  ret;
      }
    }

    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue();
        Thread product = new Thread(()->{
            int i = 1;
            while (true) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产元素:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });
        Thread customer = new Thread(()->{
            while (true) {
                try {
                    Integer take = queue.take();
                    System.out.println("消费元素:"+ take);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        product.start();
        customer.start();
    }

}
