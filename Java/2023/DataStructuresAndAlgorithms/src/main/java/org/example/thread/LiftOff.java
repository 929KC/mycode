package org.example.thread;


public class LiftOff implements Runnable{
    protected int countDown  = 10;
    private static  int taskCount=0;
    private final int id = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#"+id+"("
                +(countDown>0?countDown:"Liftoff!")+")";
    }
    public LiftOff() {
    }

    @Override
    public void run() {
        while (countDown-- >0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff l = new LiftOff();
        l.run();
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("wait liftOff");
    }
}
