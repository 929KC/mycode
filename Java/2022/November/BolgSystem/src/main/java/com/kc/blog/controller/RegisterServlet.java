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
 * @date 2022/12/2 8:31
 * @description:
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserMapper userMapper = new UserImpl();

        if (username == null || password == null || username.equals("") || password.equals("")) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("账户和密码都不能为空");
            return;
        }
        User user = userMapper.getUserByName(username);
        if (user!=null&&user.getUsername().equals(username)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("该用户已经被注册");
            return;
        }
        User newUser = new User(username, password);
        userMapper.insetUser(newUser);
        response.sendRedirect("index.html");
    }
}
