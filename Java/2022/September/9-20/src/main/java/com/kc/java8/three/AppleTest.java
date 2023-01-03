package com.kc.java8.three;

import com.kc.java8.two.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class AppleTest {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("red", 120),
                new Apple("green", 140),
                new Apple("yellow", 150));
        List<Apple> res = filterApples(list, t -> "red".equals(t.getColor()));
        System.out.println(res);
        list.sort(new AppleComparator());
        System.out.println(list);
        list.sort(( o1,  o2) -> o1.getWeight()-o2.getWeight());
        System.out.println(list);
        Comparator<Apple> c= Comparator.comparing((Apple a)->a.getWeight());
        list.sort(Comparator.comparing((a)->a.getWeight()));
        System.out.println(list);
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(list);
        list.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(list);

    }

    /**
     * 行为参数化 多态  使用泛型进一步抽象
     *
     * @param inventory
     * @param p
     * @return
     */

    public static <T> List<T> filterApples(List<T> inventory, ApplePredicate<T> p) {
        List<T> list = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                list.add(t);
            }
        }
        return list;
    }
}
