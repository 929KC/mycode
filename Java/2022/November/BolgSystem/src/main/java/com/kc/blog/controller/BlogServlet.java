package com.kc.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.blog.dao.BlogMapper;
import com.kc.blog.dao.impl.BlogImpl;

import com.kc.blog.model.Blog;
import com.kc.blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/11/28 20:08
 * @description:
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper object = new ObjectMapper();
    private BlogMapper blogMapper = new BlogImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        String blogId = request.getParameter("blogId");
        if (blogId != null) {
            Blog blog = blogMapper.getBlogById(Integer.parseInt(blogId));
            response.getWriter().write(object.writeValueAsString(blog));
        } else {
            List<Blog> blogs = blogMapper.selectAll();
            response.getWriter().write(object.writeValueAsString(blogs));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("text/html; charset=utf8");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.setStatus(403);
            response.getWriter().write("当前未登录, 不能发布博客!");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.setStatus(403);
            response.getWriter().write("当前未登录, 不能发布博客!");
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());
        blogMapper.insertBlog(blog);
        response.sendRedirect("blog_list.html");
    }
}