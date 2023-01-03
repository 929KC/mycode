package com.bit.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列
 * 1.线程安全
 * 2.带有阻塞功能
 * (a)如果队列满,继续入队列,入队列操作就会阻塞,直到队列不满,入队列才能完成
 * (b)如果队列空,继续出队列,出队列操作也会阻塞,直到队列不空,出队列才能完成
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(100);

        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        Integer val1 = blockingQueue.take();
        System.out.println(val1);
        Integer val2 = blockingQueue.take();
        System.out.println(val2);
        Integer val3 = blockingQueue.take();
        System.out.println(val3);
        blockingQueue.take();
    }
}
