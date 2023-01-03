package com.kc.design.iterator;

import java.util.ArrayList;

/**
 * 书架(具体的集合类)
 */
public class BookShelf implements Aggregate {
    public ArrayList books;
    public int last = 0;

    public BookShelf(int  initialsize) {
        this.books = new ArrayList(initialsize);
    }

    public  Book getBookAt(int index) {
        return (Book) this.books.get(index);
    }
    public void append(Book book) {
       books.add(book);
    }

    public int getLength() {
        return  books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
