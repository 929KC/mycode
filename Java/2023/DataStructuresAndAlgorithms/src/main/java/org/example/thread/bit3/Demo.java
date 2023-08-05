package org.example.thread.bit3;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool();

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            myThreadPool.submit(() -> someTask(Thread.currentThread().getName(),taskId));
        }
        Thread.sleep(1000);
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

