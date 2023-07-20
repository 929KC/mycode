package org.example.thread.consume;

import org.example.thread.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockingQueues {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String message, BlockingQueue<LiftOff> queue) {
        System.out.println(message);
        LiftOfRunner runner = new LiftOfRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getkey("Press Enter("+message+")");
        t.interrupt();
        System.out.println("Finished"+message+"test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        test("SynchronousBlockingQueue", new SynchronousQueue<LiftOff>());
    }
}
