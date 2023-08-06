package org.example.thread.deadlock;




public class Philosopher implements Runnable {
    /**
     * 左手筷子
     */
    private Chopstick left;
    /**
     * 右手筷子
     */
    private Chopstick right;
    /**
     * 名字
     */
    private String name;

    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public void thinking() {
        System.out.println(this.name + " " + "thinking");

    }

    public void eating() {
        System.out.println(this.name + " " + "eating");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            thinking();
            synchronized (this.right) {
                synchronized (this.left) {
                    eating();
                }
            }
        }
    }
}
