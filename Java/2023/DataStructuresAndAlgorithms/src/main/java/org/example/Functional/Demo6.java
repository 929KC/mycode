package org.example.Functional;

import org.example.Functional.model.Author;
import org.example.Functional.model.Book;

import java.util.*;

import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().distinct().forEach(Author-> System.out.println(Author.getName()));
    }
    public static void main25(String[] args) {
        List<Author> authors = getAuthors();
        Stream<Author> stream = authors.stream();
        stream.filter(new Predicate<Author>() {
            @Override
            public boolean test(Author author) {
                return author.getAge()>17;
            }
        }.negate()).forEach(author-> System.out.println(author));
    }
    public static void main24(String[] args) {
        List<Author> authors = getAuthors();
        authors.parallelStream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(age -> System.out.println(age));
    }
    public static void main23(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream.parallel()
                .peek(num -> System.out.println(num+Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                        .orElse(0);
        System.out.println(sum);
    }
    public static void main22(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream.parallel()
                .peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer num) {
                        System.out.println(num+Thread.currentThread().getName());
                    }
                })
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                .get();
        System.out.println(sum);
    }
    public static void main21(String[] args) {
        List<Author> authors = getAuthors();
        long start1 =System.currentTimeMillis();
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
        long end1 =System.currentTimeMillis();
        System.out.println("转换前:"+(end1-start1));
        long start2 =System.currentTimeMillis();
        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age->age>18)
                .map(age->age+2)
                .forEach(System.out::println);
        long end2 =System.currentTimeMillis();
        System.out.println("转换后:"+(end2-start2));
    }
    public static void main20(String[] args) {
        List<Author> authors = getAuthors();
        Integer min = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer result, Integer element) {
                        return result > element ? element : result;
                    }
                });
        System.out.println(min);
    }

    public static void main19(String[] args) {
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer+integer2;
                    }
                });
        System.out.println(reduce);
    }
    public static void main18(String[] args) {
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }
    public static void main17(String[] args) {
        List<Author> authors = getAuthors();
        boolean b = authors.stream().noneMatch(author -> author.getAge() > 100);
        System.out.println(b);//true
    }
    public static void main16(String[] args) {
        List<Author> authors = getAuthors();
        boolean b = authors.stream().allMatch(author -> author.getAge() >=18);
        System.out.println(b);
    }
    public static void main15(String[] args) {
        List<Author> authors = getAuthors();
        boolean b = authors.stream().anyMatch(author -> author.getAge() > 30);
        System.out.println(b);
    }
    public static void main14(String[] args) {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> map = authors.stream().distinct().
                collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }
    public static void main13(String[] args) {
        List<Author> authors = getAuthors();
        Set<Book> collect = authors.stream().flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(collect);
    }
    public static void main12(String[] args) {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream().map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void main11(String[] args) {
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream().flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);

        Optional<Integer> min = authors.stream().flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        System.out.println("max:"+max.get());
        System.out.println("min:"+min.get());

    }
    public static void main10(String[] args) {
        List<Author> authors = getAuthors();
        long count = authors.stream().flatMap(author -> author.getBooks().stream()).distinct().count();
        System.out.println(count);
    }
    public static void main9(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().map(author->author.getName()).distinct().forEach(name -> System.out.println(name));
    }
    public static void main8(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> combinedStream = Stream.concat(stream1, stream2);
        combinedStream.forEach(System.out::println);  // 输出 1, 2, 3, 4, 5, 6
    }
    public static void main7(String[] args) {
        List<Author> authors = getAuthors();
        //将每个作者的作品提取出来转换成新的流
        authors.stream().flatMap(author->author.getBooks().stream())
                .distinct().forEach(book-> System.out.println(book.getName()));

    }
    public static void main6(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().distinct().sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .skip(1).
                forEach(author-> System.out.println(author.getName()));

    }
    public static void main5(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().sorted((o1,o2)->o1.getAge()-o2.getAge())
                .forEach(author-> System.out.println(author.getAge()));
    }
    public static void main4(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().distinct().forEach(Author-> System.out.println(Author.getName()));
    }
    public static void main3(String[] args) {
        List<Author> authors = getAuthors();
        List<String> collect = authors.stream().map(author -> author.getName()).collect(Collectors.toList());

    }
    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("张三",20);
        map.put("李四",10);
        map.put("王五",28);
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
    }

    public static void main2(String[] args) {
        List<Author> authors = getAuthors();
        authors.stream().filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));

    }


    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
