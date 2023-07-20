package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    public Meal meal;
    public ExecutorService exec = Executors.newCachedThreadPool();
    public WaitPerson waitPerson = new WaitPerson(this);
    public Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public   static void main(String[] args) {
        new Restaurant();
    }

}
