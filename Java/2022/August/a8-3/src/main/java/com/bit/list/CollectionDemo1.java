package com.bit.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
            // 有序 可重复 有索引
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.remove("1");
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.contains("2"));
        Object   [] s = list.toArray();
        System.out.println(Arrays.toString(s));
        System.out.println(list);
            // 无序 不重复  无索引
        Collection set = new HashSet();
            set.add(1);
            set.add(1);
            set.add(2);
            set.add(2);
            set.add(3);
            set.add(3);
           System.out.println(set);
    }
}
