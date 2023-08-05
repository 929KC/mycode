package org.example.thread.bit;


public class MyThread extends Thread {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public MyThread(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "("
                + (countDown > 0 ? countDown : "MyThreadOff!") + ")";
    }

    public MyThread() {
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello World"));
        t.start();
        Thread t2  = new Thread(() -> System.out.println("Hello World"));
        t2.start();
    }
}
