package com.kc.java8.three;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        System.out.println(stream);
        Map<String,Integer> map = new HashMap<>();
        //键值对流
        Stream<Map.Entry<String, Integer>> stream1 = map.entrySet().stream();
        //值流
        Stream<Integer> stream2 = map.values().stream();
        //键流
        Stream<String> stream3 = map.keySet().stream();
        String [] names = {"黄茂云","叶秋涵","叶子秋"};
        //数组获取流
        Stream<String> stream4 = Arrays.stream(names);
        Stream<String> names1 = Stream.of(names);
    }
}
