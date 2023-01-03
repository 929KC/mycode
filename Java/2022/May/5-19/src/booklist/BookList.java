package booklist;

import book.Book;




/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-19 13:00
 */

public class BookList {
    private Book[] books=new Book[10];
    private int userSized;

    public BookList() {
       books[0]=new Book("红楼梦","曹雪芹",90,"小说");
        books[1]=new Book("三国演义","罗贯中",80,"小说");
        books[2]=new Book("西游记","吴承恩",70,"小说");
        books[3]=new Book("水浒传","施耐庵",60,"小说");
        this.userSized = 4;
    }

    public Book getBook(int pos) {
        if(pos<0||pos>books.length){
            return null;
        }
        return books[pos];
    }

    public void setBooks(int pos,Book book) {
        if(pos<0||pos>books.length){
            return ;
        }
        books[pos]=book;
    }

    public int getUserSized() {
        return userSized;
    }

    public void setUserSized(int userSized) {
        this.userSized = userSized;
    }

}
