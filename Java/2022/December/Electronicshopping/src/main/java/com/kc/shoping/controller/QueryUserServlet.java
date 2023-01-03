package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.UserMapper;
import com.kc.shoping.mapper.impl.UserImpl;
import com.kc.shoping.vo.QueryUserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/12 10:35
 * @description:
 */
@WebServlet("/query")
public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        UserMapper userMapper = new UserImpl();
        List<QueryUserVo> queryUserVo = userMapper.queryUserVo();
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(queryUserVo));
    }
}
