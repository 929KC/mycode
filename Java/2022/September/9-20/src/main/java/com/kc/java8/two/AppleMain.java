//package com.kc.java8.two;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class AppleMain {
//    public static void main(String[] args) {
//        Apple a1 = new Apple();
//        a1.setColor("red");
//        a1.setWeight(140);
//        Apple a2 = new Apple();
//        a2.setColor("green");
//        a2.setWeight(150);
//        Apple a3 = new Apple();
//        a3.setColor("blue");
//        a3.setWeight(120);
//        List<Apple> list = Arrays.asList(a1,a2,a3);
// //       List<Apple> res1 = filterApplesByColor(list);
////        System.out.println(res1);
////        List<Apple> res2 = filterApplesByWeight(list);
////        System.out.println(res2);
//        ApplePredicate<A> p1 = new AppleGreenColorPredicate();
//        ApplePredicate<A> p2 = new AppleHeavyWeightPredicate();
//        List<Apple> res1 = filterApples(list, p1);
//        System.out.println(res1);
//        List<Apple> res2 = filterApples(list, p2);
//        System.out.println(res2);
//        //匿名内部类占用很多空间吗?
//        List<Apple> res3 = filterApples(list, new ApplePredicate<A>() {
//            @Override
//            public boolean test(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });
//        System.out.println(res3);
//
//        //匿名内部类占用很多空间吗?
//        List<Apple> res4 = filterApples2(list, new ApplePredicate<A>() {
//            @Override
//            public boolean test(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });
//        System.out.println(res4);
//    }
//    public static List<Apple> filterApplesByColor(List<Apple> inventory) {
//        List<Apple> res = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if ("green".equals(apple.getColor())) {
//                res.add(apple);
//            }
//        }
//        return  res;
//    }
//
//    public static List<Apple> filterApplesByWeight(List<Apple> inventory) {
//        List<Apple> res = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getWeight()>140) {
//                res.add(apple);
//            }
//        }
//        return  res;
//    }
//
//    /**
//     * 行为参数化 多态  版本1
//     * @param inventory
//     * @param p
//     * @return
//     */
//    public  static  List<Apple> filterApples(List<Apple> inventory,ApplePredicate<A> p) {
//        List<Apple> list = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (p.test(apple)) {
//                list.add(apple);
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 行为参数化 多态  版本1 使用泛型进一步抽象
//     * @param inventory
//     * @param p
//     * @return
//     */
//    public  static <T> List<T> filterApples2(List<T> inventory,ApplePredicate<A> p) {
//        List<T> list = new ArrayList<>();
//        for (T t : inventory) {
//            list.add(t);
//        }
//        return list;
//    }
//
//}
