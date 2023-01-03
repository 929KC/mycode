package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.MessageMapper;
import com.kc.shoping.mapper.impl.MessageImpl;
import com.kc.shoping.vo.MessageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/13 10:12
 * @description:
 */
@WebServlet("/show")
public class ShowMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String messageId = request.getParameter("id");
        int id = Integer.parseInt(request.getParameter("id"));
        MessageMapper mapper = new MessageImpl();
        MessageVo messageVo =  mapper.queryMessageVo(id);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(messageVo));
    }
}
