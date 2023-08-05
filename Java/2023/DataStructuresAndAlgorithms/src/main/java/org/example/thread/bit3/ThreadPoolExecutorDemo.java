package org.example.thread.bit3;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
                2,
                2,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            threadExecutor.submit(()->someTask(Thread.currentThread().getName(),taskId));
        }
        threadExecutor.shutdown();
    }

    /**
     * 定义一个需要并发执行的任务
     *
     * @param taskId
     */
    private static void someTask(String name,int taskId) {
        System.out.println(name+":Task " + taskId + " is starting...");
        try {

            Thread.sleep(2000); // 模拟任务执行时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " is finished!");
    }
}
