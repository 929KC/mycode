package com.bit.dao;

import com.bit.bean.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-20 19:24
 */

public interface BookMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBook(@Param("bookId") int id);
    //更新一本书
    int updateBook(Books book);
    //查询一本书
    Books queryBookById(@Param("bookId")int id);
    //查询全部的书
    List<Books> queryAllBook();
}
