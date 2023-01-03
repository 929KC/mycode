package com.kc.design.iterator;

import org.junit.Test;

public class BookShelfTest {

    @Test
    public void testBookShelf() {
        BookShelf bookshelf = new BookShelf(4);
        bookshelf.append(new Book("红楼梦"));
        bookshelf.append(new Book("三国演义"));
        bookshelf.append(new Book("活着"));
        bookshelf.append(new Book("白夜行"));
        Iterator iterator = bookshelf.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println(bookshelf.getLength());
    }
}
