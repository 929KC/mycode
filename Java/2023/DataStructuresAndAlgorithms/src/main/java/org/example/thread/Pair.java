package org.example.thread;


public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    public void checkState() {
        if (x != y) {
            //throw new PairValuesNotEqualException();
        }
    }

    @Override
    public String toString() {
        return
                "x:" + x +
                ", y:" + y ;
    }


}
