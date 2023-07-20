package org.example.thread;

public class Task implements Runnable{
    public static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
        System.out.println(blocker);
    }
}
