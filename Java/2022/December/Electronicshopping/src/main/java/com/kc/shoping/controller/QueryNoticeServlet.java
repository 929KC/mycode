package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.NoticeMapper;
import com.kc.shoping.mapper.impl.NoticeMapperImpl;
import com.kc.shoping.model.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author 929KC
 * @date 2022/12/13 15:59
 * @description:
 */
@WebServlet("/queryNotice")
public class QueryNoticeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        NoticeMapper noticeMapper = new NoticeMapperImpl();
        List<Notice> list = noticeMapper.queryNotice();
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(list));
    }
}
