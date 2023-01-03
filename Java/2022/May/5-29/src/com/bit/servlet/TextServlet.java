package com.bit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-29 08:49
 */

public class TextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求体的字符集
       // request.setCharacterEncoding("UTF-8");
        // 获取用户提交的用户名
        String username = request.getParameter("username");
        // 输出username
        System.out.println(username);
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("大家好，我是一名Java软件工程师");
    }
}
