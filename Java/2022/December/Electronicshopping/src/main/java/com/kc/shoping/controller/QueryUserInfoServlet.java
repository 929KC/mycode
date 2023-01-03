package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.UserMapper;
import com.kc.shoping.mapper.impl.UserImpl;
import com.kc.shoping.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 929KC
 * @date 2022/12/12 17:00
 * @description:
 */
@WebServlet("/queryInfo")
public class QueryUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String id = request.getParameter("id");
        UserMapper userMapper = new UserImpl();
        User user = userMapper.queryUser(Integer.parseInt(id));
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
