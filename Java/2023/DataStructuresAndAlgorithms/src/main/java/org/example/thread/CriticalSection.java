package org.example.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pman1);
        PairManipulator pm2 = new PairManipulator(pman2);
        PairChecker checker1 = new PairChecker(pman1);
        PairChecker checker2 = new PairChecker(pman2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(checker1);
        executorService.execute(checker2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1:"+pm1+"\npm2:"+pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager manager1 = new PairManager1();
        PairManager manager2 = new PairManager2();
        testApproaches(manager1, manager2);
    }
}
