package com.kc.java8.three;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("叶秋涵");
        list.add("叶秋涵");
        list.add("赵敏");
        list.add("张无忌");
        list.add("谢逊");
        list.add("小昭");
        list.add("小昭");
        list.add("周芷若");
        list.add("周芷若");
        list.add("张强");
        list.add("张三丰");
        list.stream().filter(s -> s.startsWith("叶")).forEach( s-> System.out.println(s));
        list.stream().filter(s->s.startsWith("小")).forEach(s-> System.out.println(s));
        long count = list.stream().filter(s -> s.length() == 3).count();
        System.out.println(count);
        list.stream().filter(s->s.startsWith("张")).limit(1).forEach(System.out::println);
        list.stream().filter(s->s.startsWith("张")).skip(1).limit(1).forEach(System.out::println);
        list.stream().distinct().forEach(System.out::println);
        list.stream().map(s->"B站:"+s).forEach(a-> System.out.println(a));
        list.stream().map(s->new Studnet(s)).forEach(s-> System.out.println(s));
    }
}
