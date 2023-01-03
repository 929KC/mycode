package com.bit.dao;

import com.bit.bean.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);
    //查询博客
    List<Blog> queryBlogIF(Map map);

     List<Blog> queryBlogChoose(Map map);

    List<Blog> updateBlog(Map map);
}
