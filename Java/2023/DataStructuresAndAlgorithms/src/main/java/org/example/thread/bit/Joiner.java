package org.example.thread.bit;

/**
 *
 */
public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();//等待Sleeper结束,挂起的是Joiner
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+" join completed");
    }

    public static void main(String[] args) {
        Sleeper grumpy = new Sleeper("Grumpy",2500);
        Sleeper sleeper = new Sleeper("Sleeper",250000);
        Joiner doc = new Joiner("Doc",grumpy);
        Joiner dopey = new Joiner("Dopey",sleeper);
        grumpy.interrupt();//使得该线程触发异常-InterruptedException
    }
}
