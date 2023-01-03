package com.bit.list;

import java.util.ArrayList;
import java.util.Collection;


public class CollectionDemo2 {
    public static void main(String[] args) {
       Collection<String> list = new ArrayList<String>();
        list.add("小黄");
        list.add("大黄");
        list.add("阿黄");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
