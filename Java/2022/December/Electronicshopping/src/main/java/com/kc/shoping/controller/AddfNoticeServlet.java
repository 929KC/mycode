package com.kc.shoping.controller;

import com.kc.shoping.mapper.NoticeMapper;
import com.kc.shoping.mapper.impl.NoticeMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/13 16:40
 * @description:1
 */
@WebServlet("/addNotice")
public class AddfNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        NoticeMapper noticeMapper = new NoticeMapperImpl();
        noticeMapper.addNotice(title,content);
        response.sendRedirect("manageGonggao.html");
    }
}
