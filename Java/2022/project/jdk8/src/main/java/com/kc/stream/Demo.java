package com.kc.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * @author 929KC
 * @date 2022/11/26 19:48
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
         List<Author> authors = getAuthors();
//         authors.stream().distinct().filter(author -> author.getAge()<18).forEach(author -> System.out.println(author.getName()));
//         authors.stream().map(author -> author.getName()).forEach(author -> System.out.println(author));
//        int [] arr = new int[]{1,2,2,3,4,4,5,5,66,7,7,8,8,9};
//        Arrays.stream(arr).distinct().forEach(value -> System.out.println(value));
//        authors.stream().distinct().sorted((o1, o2) -> o1.getAge()-o2.getAge()).forEach(author -> System.out.println(author.getName()));
//        authors.stream().distinct().sorted((o1, o2) -> o2.getAge()-o1.getAge()).limit(2).forEach(author -> System.out.println(author.getName()));
         authors.stream().flatMap((Function<Author, Stream<Book>>) author -> author.getBooks().stream()).distinct().forEach(book -> System.out.println(book.getName()));
    }
    private static List<Author> getAuthors() {
        Author author1 = new Author(1L, "司马迁", "历史书" ,18, null);
        Author author2 = new Author(2L, "曹雪芹", "小说",19, null);
        Author author3 = new Author(3L, "吴承恩","小说", 14, null);
        Author author4 = new Author(4L, "余华", "小说" ,29, null);
        Author author5 = new Author(5L, "莫言","小说" ,12, null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        // 上面是作者和书
        books1.add(new Book(1L, "类别,分类啊", "书名1", 45, "这是简介哦"));
        books1.add(new Book(2L, "高效", "书名2", 84, "这是简介哦"));
        books1.add(new Book(3L, "喜剧", "书名3", 83, "这是简介哦"));

        books2.add(new Book(5L, "天啊", "书名4", 65, "这是简介哦"));
        books2.add(new Book(6L, "高效", "书名5", 89, "这是简介哦"));

        books3.add(new Book(7L, "久啊", "书名6", 45, "这是简介哦"));
        books3.add(new Book(8L, "高效", "书名7", 44, "这是简介哦"));
        books3.add(new Book(9L, "喜剧", "书名8", 81, "这是简介哦"));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        author5.setBooks(books2);

        return new ArrayList<>(Arrays.asList(author1, author2, author3, author4, author5));
    }
}
