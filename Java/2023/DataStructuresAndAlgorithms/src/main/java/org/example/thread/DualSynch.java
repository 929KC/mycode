package org.example.thread;

public class DualSynch {
    private static Object lock = new Object();

    public synchronized void f(){
        for (int i = 0; i <5;i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public  void g(){
        synchronized (lock) {
            for (int i = 0; i <5;i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(){
            @Override
            public void run() {
                ds.f();
            }
        }.start();
        ds.g();
    }
}
