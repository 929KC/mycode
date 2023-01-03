package com.kc.jsp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.jsp.mapper.T_flow_step_defMapper;
import com.kc.jsp.mapper.impl.T_flow_step_defImpl;
import com.kc.jsp.model.T_flow_step_def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/9 9:30
 * @description:
 */
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        T_flow_step_defMapper t = new T_flow_step_defImpl();
        List<T_flow_step_def> list = t.queryAll();
        if (list == null) {
            response.sendRedirect("error.html");
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().write(objectMapper.writeValueAsString(list));
        }
    }
}
