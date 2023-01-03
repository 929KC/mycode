package com.kc.blog.dao.impl;

import com.kc.blog.model.Blog;
import com.kc.blog.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 929KC
 * @date 2022/11/13 20:36
 * @description: Blog具体实现类
 */
public class BlogImpl implements com.kc.blog.dao.BlogMapper {
    @Override
    public void insertBlog(Blog blog) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //获取数据库连接
            conn = DBUtil.getConnection();
            String sql = "insert into blog(title,content,userId,postTime)  values(?,?,?,now())";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getUserId());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn, stmt, null);
        }
    }

    @Override
    public List<Blog> selectAll() {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select *from blog order by postTime desc";
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                Blog blog = new Blog();
                blog.setBlogId(result.getInt("blogId"));
                blog.setTitle(result.getString("title"));
                String content = result.getString("content");
                if (content.length()>50) {
                    content = content.substring(0,50)+"....";
                }
                blog.setContent(content);
                blog.setPostTime(result.getTimestamp("postTime"));
                blog.setUserId(result.getInt("userId"));
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, result);
        }
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            String sql = "select * from blog where blogId = ?";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            result = statement.executeQuery();
            while (result.next()) {
                Blog blog = new Blog();
                blog.setBlogId(result.getInt("blogId"));
                blog.setTitle(result.getString("title"));
                blog.setContent(result.getString("content"));
                blog.setUserId(result.getInt("userId"));
                blog.setPostTime(result.getTimestamp("postTime"));
                return blog;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,result);
        }
        return null;
    }

    @Override
    public void deleteBlog(int blogId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "delete from blog where blogId = ?";
            connection = DBUtil.getConnection();
            statement =  connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            statement.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.close(connection,statement,null);
        }
    }

    @Override
    public void updateBlog(Blog blog) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update blog set content = ?,title = ? where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getContent());
            statement.setString(2,blog.getTitle());
            statement.setInt(3,blog.getBlogId());
            int i = statement.executeUpdate();
            if (i==1) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }catch (SQLException throwables) {

        }finally {
            DBUtil.close(connection,statement,null);
        }
    }

    @Override
    public Integer selectTotal(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select count(userId) from blog where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            result = statement.executeQuery();
            if (result.next()) {

            }
            return result.getInt(1);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.close(connection,statement,result);
        }
        return null;
    }
}
