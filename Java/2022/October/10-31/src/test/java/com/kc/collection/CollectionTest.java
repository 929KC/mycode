package com.kc.collection;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionTest {
    @Test
    public void ColletcionApl(){
        Collection<String> list = new ArrayList();
        list.add("叶秋涵");
        list.add("叶子秋");
        list.add("林黛玉");
        list.add("贾宝玉");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("史湘云");
        list2.add("妙玉");
        list2.add("秦可卿");
        list.addAll(list2);
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println(list.contains("林黛玉"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.containsAll(list2));
        String [] s = new String [20];
        String[] strings = list.toArray(s);
        System.out.println(Arrays.toString(strings));
        String [] s2 = new String [7];
        String[] strings2 = list.toArray(s2);
        System.out.println(Arrays.toString(strings2));
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("史湘云");
            }
        };
        System.out.println(list.removeIf(predicate));
        System.out.println(list);
        list.forEach(e-> System.out.print(e));
    }

    @Test
    public  void Java8PredicateTest(){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("我是叶秋涵");
            }
        };
        System.out.println(predicate.test("我是叶秋涵"));

    }

    /**
     * and相当于&&
     */
    @Test
    public  void Java8PredicateTest2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Predicate<Integer> greaterThan5 = number ->number>5;
        Predicate<Integer> lessThan9 = number ->number<9;
        Predicate<Integer> filter = greaterThan5.and(lessThan9);
        list = list.stream().filter(filter).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     *predicate.negate() 方法会返回一个与指定判断相反的 Predicate。
     */
    @Test
    public  void Java8PredicateTest3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Predicate<Integer> greaterThan5 = number ->number>5;
        list = list.stream().filter(greaterThan5.negate()).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * or或者
     */
    @Test
    public  void Java8PredicateTest5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Predicate<Integer> greaterThan5 = number ->number<=5;
        Predicate<Integer> greaterThan9 = number ->number>=9;
        list = list.stream().filter(greaterThan5.or(greaterThan9)).collect(Collectors.toList());
        System.out.println(list);
    }
    @Test
    public void test(){
        int [] arr = new int []{1,2,3,4,6,6,3,23,574,525,52};
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if (arr[i]>max) {
                max =arr[i];
            }
        }   
        System.out.println(max);
    }

    @Test
    public void testCollections(){
        ArrayList<String> list = new ArrayList<>();
        //一次性向集合添加多个元素
        Collections.addAll(list,"林黛玉","妙玉","史湘云","张飞","贾宝玉","薛宝钗");
        System.out.println("未排序前:"+list);
        //使用默认的随机源随机排列指定的列表。
        System.out.println("随机排列指定前:"+list);
        Collections.shuffle(list);
        System.out.println("随机排列指定后:"+list);
        //将集合中元素按照默认规则排序。
        System.out.println("自然排序前:"+list);
        Collections.sort(list);
        System.out.println("自然排序后:"+list);
    }
    @Test
    public void testCollections2(){
        List<Apple> apples = new ArrayList<>(); // 可以重复！
        apples.add(new Apple("毒苹果", "黑色", 9.9, 500));
        apples.add(new Apple("青苹果", "绿色", 15.9, 300));
        apples.add(new Apple("红苹果", "功色", 29.9, 400));
        apples.add(new Apple("黄苹果", "黄色", 9.8, 500));
       // 方法一：Apple类已经重写了比较规则，可以使用
        Collections.sort(apples);
        System.out.println(apples);
         //方式二：sort方法自带比较器对象
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Double.compare(o1.getPrice() , o2.getPrice()); // 按照价格排序！！
            }
        });
        System.out.println(apples);
    }
}
