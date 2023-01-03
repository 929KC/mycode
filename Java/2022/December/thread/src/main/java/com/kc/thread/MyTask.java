package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/18 15:15
 * @description:
 */
public class MyTask implements Comparable<MyTask> {
    private Runnable runnable;
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time+System.currentTimeMillis();
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time-o.time);
    }
}
