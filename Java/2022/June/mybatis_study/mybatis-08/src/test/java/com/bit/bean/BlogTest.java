package com.bit.bean;

import com.bit.dao.BlogMapper;
import com.bit.utils.IDutils;
import com.bit.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 19:40
 */

public class BlogTest {
    @Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setId(1);
        blog.setTitle("mybatis");
        blog.setAuthor("叶秋涵");
        blog.setCreateTime(new Date());
        blog.setViews(90);
        mapper.addBlog(blog);

        blog.setId(2);
        blog.setTitle("spring");
        mapper.addBlog(blog);

        blog.setId(3);
        blog.setTitle("springMVC");
        mapper.addBlog(blog);
        sqlSession.close();
    }

    @Test
    public void  queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("title","mybatis");
        map.put("author","叶秋涵");
        List<Blog> blog=mapper.queryBlogIF(map);
        for (Blog blog1 : blog) {
            System.out.println(blog1);
        }
        sqlSession.close();

    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        map.put("title","mybatis");
        map.put("author","叶秋涵");
        map.put("views",90);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void  updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
         map.put("title","mybatis");
        //map.put("author","叶秋涵");
       // map.put("views",90);
        //map.put("id","2");
        mapper.updateBlog(map);
        sqlSession.close();
    }
}
