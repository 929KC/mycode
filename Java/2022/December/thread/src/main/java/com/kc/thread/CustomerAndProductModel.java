package com.kc.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 929KC
 * @date 2022/12/18 7:48
 * @description:
 */
public class CustomerAndProductModel {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        Thread customer = new Thread(() -> {
            while (true) {
                try {
                    int value = queue.take();
                    System.out.println("消费元素:" + value);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者");
        Thread product = new Thread(() -> {
            Random rand = new Random();
            while (true) {
                try {
                    int num = rand.nextInt(10);
                    System.out.println("生产元素:" + num);
                    queue.put(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "生产者");
        product.start();
        customer.start();

        customer.join();
        product.join();
    }
}
