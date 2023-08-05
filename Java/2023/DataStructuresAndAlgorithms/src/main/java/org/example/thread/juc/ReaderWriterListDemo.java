package org.example.thread.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderWriterListDemo {
    public static void main(String[] args) {
       List<Integer> list = new ArrayList<>(100);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
