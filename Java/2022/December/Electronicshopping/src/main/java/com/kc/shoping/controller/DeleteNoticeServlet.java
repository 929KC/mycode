package com.kc.shoping.controller;

import com.kc.shoping.mapper.MessageMapper;
import com.kc.shoping.mapper.NoticeMapper;
import com.kc.shoping.mapper.impl.MessageImpl;
import com.kc.shoping.mapper.impl.NoticeMapperImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 929KC
 * @date 2022/12/13 16:32
 * @description:
 */
@WebServlet("/deleteNotice")
public class DeleteNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String messageId = request.getParameter("id");
        int id = Integer.parseInt(request.getParameter("id"));
        NoticeMapper noticeMapper = new NoticeMapperImpl();
        noticeMapper.deleteNotice(id);
        response.sendRedirect("manageGonggao.html");
    }
}
