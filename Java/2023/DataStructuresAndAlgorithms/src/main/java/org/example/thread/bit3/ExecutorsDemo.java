package org.example.thread.bit3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.submit(()->someTask(Thread.currentThread().getName(),taskId));
        }
        executorService.shutdown();
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
