package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/18 9:57
 * @description:
 */
public class MyBlockingQueue {
    int[] arr = new int[1];
    int size = 0;
    int tail = 0;
    int head = 0;

    public void put(int elem) throws InterruptedException {
        synchronized (this) {
            //防止被其它的情况唤醒(inpuert())
            while (this.size >= arr.length) {
                this.wait();
            }
            this.arr[this.tail++] = elem;
            this.size++;
            if (this.tail >= this.arr.length) {
                this.tail = 0;
            }
            this.notify();
        }
    }

    public int take() throws InterruptedException {
        synchronized (this) {
            while (this.size == 0) {
                this.wait();
            }
            int ret = this.arr[this.head++];
            if (this.head >= this.arr.length) {
                this.head = 0;
            }
            this.size--;
            this.notify();
            return ret;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    myBlockingQueue.put(i);
                    System.out.println("生产一个元素:" + i);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");
        t1.start();
        Thread t2 = new Thread(() -> {
           while (true) {
               try {
                   int i = myBlockingQueue.take();
                   System.out.println("消费一个元素:"+i);
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }, "消费者");
        t2.start();
    }
}
