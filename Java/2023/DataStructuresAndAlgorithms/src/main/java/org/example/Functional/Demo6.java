package org.example.Functional;

import org.example.Functional.model.Author;
import org.example.Functional.model.Book;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        Stream<Book> bookStream = authors.stream()
                .flatMap(author -> author.getBooks().stream());


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
