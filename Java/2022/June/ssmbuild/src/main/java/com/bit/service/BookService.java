package com.bit.service;

import com.bit.bean.Books;
import com.bit.dao.BookMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-20 19:39
 */

public class BookService {
    //service调用dao层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    //增加一本书
   public  int addBook(Books books){
        return bookMapper.addBook(books);
   }

    //删除一本书
   public int deleteBook(int id){
       return  bookMapper.deleteBook(id);
    }
    //更新一本书
   public int updateBook(Books book){
      return   bookMapper.updateBook(book);
    }
    //查询一本书
    Books queryBookById(int id){
        return bookMapper.queryBookById(id);
    }
    //查询全部的书
   public List<Books> queryAllBook(){
        return bookMapper.queryAllBook();
    }
}
