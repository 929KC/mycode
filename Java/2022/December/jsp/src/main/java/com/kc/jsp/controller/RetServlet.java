package com.kc.jsp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.jsp.mapper.ScoreMapper;
import com.kc.jsp.mapper.impl.ScoreImpl;
import com.kc.jsp.model.AvgScore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/8 14:22
 * @description:
 */
@WebServlet("/query")
public class RetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("sdf");
        ScoreMapper scoreMapper = new ScoreImpl();
        List<AvgScore> list = scoreMapper.queryAvg();
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(list));
    }
}
