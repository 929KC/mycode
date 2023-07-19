package org.example.thread;

public class Blocked2 implements Runnable{
    BlockedMutex locked = new BlockedMutex();
    @Override
    public void run() {
        System.out.println("waiting for f() in BlockedMutex");
        locked.f();
        System.out.println("Broken out of blocked call");
    }
}
