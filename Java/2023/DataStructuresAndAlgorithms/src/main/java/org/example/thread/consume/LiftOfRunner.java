package org.example.thread.consume;




import org.example.thread.LiftOff;

import java.util.concurrent.BlockingQueue;


public class LiftOfRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOfRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public  void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during  put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
