package org.example.thread.bit2;

import java.util.Random;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerModel {
    private  static int count;
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQue = new BlockingQueue();
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Integer num = (Integer) blockingQue.take();
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("消费者消费了"+count+"个数据,"+"数据是:"+num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        consumer.start();
        Thread producer = new Thread(() -> {
            while (true) {
                Random rand = new Random();
                try {
                    Integer num = rand.nextInt();
                    count++;
                    blockingQue.put(num);
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("生产者生产了"+count+"个数据,"+"数据是:"+num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.start();
        consumer.join();
        producer.join();
    }
}
