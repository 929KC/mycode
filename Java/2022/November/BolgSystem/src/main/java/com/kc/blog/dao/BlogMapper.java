package com.kc.blog.dao;

import com.kc.blog.model.Blog;

import java.util.List;

/**
 * @author: 929KC
 * @date 2022/11/13 20:35
 * @description: 定义针对博客表的基本操作
 * @version: 0.0.1
 **/
public interface BlogMapper {
    /**
     *
     * @author 929KC
     * @date 2022/11/13 2022/11/13
     * @description: 添加博客
     * @param blog
     */
    void insertBlog(Blog blog);
    /**
     *
     * @author 929KC
     * @date 2022/11/13 2022/11/13
     * @description: 查询博客的主要内容
     * @return List<Blog>
     */
    List<Blog> selectAll();
    /**
     *
     * @author 929KC
     * @date 2022/11/13 2022/11/13
     * @description: 根据博客id去查询对应的博客
     * @param id
     * @return Blog
     */
    Blog getBlogById(int id);
    /**
     * @author 929KC
     * @date 2022/11/13 2022/11/13
     * @param blogId
     * @description: 根据博客id去删除对应的博客
     */
    void deleteBlog(int blogId);
    /**
     *
     * @author 929KC
     * @date 2022/11/13 2022/11/13
     * @param blog
     * @description: 修改博客
     */
    void updateBlog(Blog blog);

    /**
     *
     * @param userId
     * @return
     * @description: 计算个人文章的总数
     */
    Integer selectTotal(int userId);
}
