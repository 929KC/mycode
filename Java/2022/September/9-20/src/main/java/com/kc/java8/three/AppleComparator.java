package com.kc.java8.three;

import com.kc.java8.two.Apple;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
     return o1.getWeight()-o2.getWeight();
    }
}
