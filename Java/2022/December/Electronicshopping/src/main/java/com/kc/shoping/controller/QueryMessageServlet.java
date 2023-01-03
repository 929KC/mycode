package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.MessageMapper;
import com.kc.shoping.mapper.impl.MessageImpl;
import com.kc.shoping.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 9:12
 * @description:
 */
@WebServlet("/queryMessage")
public class QueryMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        MessageMapper mapper = new MessageImpl();
        List<Message> list = mapper.queryUserMessage();
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(list));
    }
}
