package com.kc.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(10);
        list.add("叶秋涵");
        list.add("林黛玉");
        list.set(0, "叶子秋");
        list.add(0, "林黛玉");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Hello World");
        list2.add("今天天气真好");
        list.addAll(list2);
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("叶秋涵");
        list3.add("林黛玉");
        list3.add("叶秋涵");
        list.retainAll(list3);
        list.add("叶秋涵");
        list.add("Hello World");
        list.add("今天天气真好");
        int [] arr = new int[]{1,2,3};

        ListIterator<String> Iterator = list.listIterator(0);
        while (Iterator.hasNext()) {
            String next = Iterator.next();
            System.out.print(next+" ");
        }
        System.out.println(list);
        System.out.println("==========================");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next+" ");
        }
        System.out.println("==========================");
        ListIterator<String> si = list.listIterator();
        while (si.hasNext()) {
            String next = si.next();
            System.out.print(next+" ");
        }
    }
}
