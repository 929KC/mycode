package org.example.thread.bit3;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private int maxWorkerCount = 10;
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();

    public void submit(Runnable command) throws InterruptedException {
        if (queue.size() < maxWorkerCount) {
            // 当前 worker 数不足, 就继续创建 worker
            Worker worker = new Worker(queue);
            worker.start();
        }
        // 将任务添加到任务队列中
        queue.put(command);
    }


}