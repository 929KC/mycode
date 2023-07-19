package org.example.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {
        AtomicInteger checkCounter = new AtomicInteger(0);
        protected Pair pair = new Pair();
        private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

        public synchronized Pair getPair() {
            return new Pair(pair.getX(), pair.getY());
        }

        protected void store(Pair pair) {
            storage.add(pair);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void increment();
    }