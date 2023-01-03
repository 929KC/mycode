package com.kc.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userPassword= request.getParameter("userpassword");
        if (username.equals("zhangsan")&&userPassword.equals("123456")) {
            response.sendRedirect("/index2.html");
        }else {
            response.sendRedirect("/login.html");
        }
    }
}
