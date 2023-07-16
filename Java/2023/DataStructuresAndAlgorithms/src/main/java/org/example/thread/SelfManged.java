package org.example.thread;

public class SelfManged implements Runnable{
    private int countDown = 5;
    private static  int count =0;
    private Thread t = new Thread(this);
    public SelfManged(){
        t.start();
    }
    @Override
    public String toString() {
        return "#"+Thread.currentThread().getName()+" ("+countDown+")";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown==0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            new SelfManged();
        }
    }
}
