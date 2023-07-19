package org.example.thread;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println(Arrays.toString(args));
        /*if (args.length!=1) {
            System.out.println("Usage: java InterruptingIdiom delat-in-mS");
            System.exit(1);
        }*/
        Thread t = new Thread(new Blocked3() );
        t.start();
        //TimeUnit.MILLISECONDS.sleep(new Integer(args[10]));
        TimeUnit.MILLISECONDS.sleep(3);
        t.interrupt();
    }
}
