package org.example.thread;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class SerialNumberChecker implements Runnable{
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService executor = Executors.newCachedThreadPool();


    @Override
    public void run() {
        while (true) {
            int serial = SerialNumberGenerator.nextSerialNumber();
            if (serials.contains(serial)) {
                System.out.println("Duplicate:"+serial);
                System.exit(0);
            }
            serials.add(serial);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <SIZE;i++) {
            executor.execute(new SerialNumberChecker());
            if (args.length>0) {
                TimeUnit.SECONDS.sleep(new Integer(args[0]));
                System.out.println("No duplicates detected");
                System.exit(0);
            }
        }
    }
}
