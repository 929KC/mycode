package com.kc.thread;

class MyBlockingQueue2 {
    private int[] items = new int[1000];
    private volatile int head = 0;
    private volatile int tail = 0;
    private volatile int size = 0;

    // 入队列
    public void put(int elem) throws InterruptedException {
        synchronized (this) {
            // 判定队列是否满了, 满了则不能插入.
            while (size >= items.length) {
                this.wait();
            }
            // 进行插入操作, 把 elem 放到 items 里, 放到 tail 指向的位置.
            items[tail] = elem;
            tail++;
            if (tail >= items.length) {
                tail = 0;
            }
            size++;
            this.notify();
        }
    }

    // 出队列, 返回删除的元素内容
    public Integer take() throws InterruptedException {
        synchronized (this) {
            // 判定队列是否空, 如果空了, 则不能出队列
            while (size == 0) {
                this.wait();
            }
            // 进行取元素操作.
            int ret = items[head];
            head++;
            if (head >= items.length) {
                head = 0;
            }
            size--;
            this.notify();
            return ret;
        }
    }
}

public class Demo23 {
    public static void main(String[] args) {
        MyBlockingQueue2 queue = new MyBlockingQueue2();
        Thread producer = new Thread(() -> {
            int n = 1;
            while (true) {
                try {
                    queue.put(n);
                    System.out.println("生产元素 " + n);
                    Thread.sleep(500);
                    n++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int n = queue.take();
                    System.out.println("消费元素 " + n);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        customer.start();
    }
}