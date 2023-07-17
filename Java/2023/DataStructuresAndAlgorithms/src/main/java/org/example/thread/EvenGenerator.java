package org.example.thread;


public class EvenGenerator extends IntGenerator{
    private static Object ob = new Object();
    private int currentEvenValue = 0;

    /**
     *生产偶数
     * @return
     */
    @Override
    public int next() {
        synchronized (ob){
            ++currentEvenValue;
            ++currentEvenValue;
      }
    return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
