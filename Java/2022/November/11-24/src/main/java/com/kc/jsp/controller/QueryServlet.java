package com.kc.jsp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.jsp.dao.StudentMapper;
import com.kc.jsp.dao.impl.StudnetImpl;
import com.kc.jsp.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/11/16 20:15
 * @description:
 */
@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        StudentMapper studentMapper = new StudnetImpl();
        List<Student> query = studentMapper.query();
        ObjectMapper om = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(om.writeValueAsString(query));
    }
}
