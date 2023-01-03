package com.kc.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.blog.dao.BlogMapper;
import com.kc.blog.dao.UserMapper;
import com.kc.blog.dao.impl.BlogImpl;
import com.kc.blog.dao.impl.UserImpl;
import com.kc.blog.model.Blog;
import com.kc.blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/11/30 19:05
 * @description:
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper object = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogId = request.getParameter("blogId");
        if (blogId == null) {
            getUserInfoFromSession(request, response);
        } else {
            getUserInfoFromDb(request, response, Integer.parseInt(blogId));
        }
    }

    private void getUserInfoFromDb(HttpServletRequest request, HttpServletResponse response, int blogId) throws IOException {
        BlogMapper blogMapper = new BlogImpl();
        Blog blog = blogMapper.getBlogById(blogId);
        if (blog == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(400);
            response.getWriter().write("该博客不存在于数据库");
            return;
        }
        UserMapper userMapper = new UserImpl();
        User user = userMapper.getUserById(blog.getUserId());
        user.setPassword(" ");
        if (user == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(400);
            response.getWriter().write("该博客不存在于数据库");
            return;
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(object.writeValueAsString(user));
    }

    private void getUserInfoFromSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.setStatus(403);
            response.setContentType("text/html;/charset=utf-8");
            response.getWriter().write("当前未登录");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.setContentType("text/html;/charset=utf-8");
            response.setStatus(403);
            response.getWriter().write("当前未登录");
            return;
        }
        user.setPassword("");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(object.writeValueAsString(user));
    }
}
