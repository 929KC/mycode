package com.kc.blog.controller;


import com.kc.blog.dao.UserMapper;

import com.kc.blog.dao.impl.UserImpl;
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
 * @date 2022/11/30 14:28
 * @description:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || password == null || username.equals("") || password.equals("")) {
            response.getWriter().write("你的账户或者密码为空");
            return;
        }
        UserMapper userMapper = new UserImpl();
        User user = userMapper.getUserByName(username);
        if (user == null || !user.getPassword().equals(password)) {
            response.getWriter().write("当前的账户或者密码错误");
            return;
        }
        HttpSession session = request.getSession(true);
        user.setPassword("");
        session.setAttribute("user", user);
        response.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session==null) {
            response.setStatus(403);
            return ;
        }
        User user = (User)session.getAttribute("user");
        if (user==null) {
            response.setStatus(403);
            return;
        }
        response.setStatus(200);
    }
}
