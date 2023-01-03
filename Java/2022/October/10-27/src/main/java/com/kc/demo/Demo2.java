package com.kc.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(1);
        list.add("叶秋涵");
        list.add("林黛玉");
        list.add("曹操");
        list.trimToSize();
        List<String> list1 = list.subList(0, 1);
        System.out.println(list1);
    }
}
