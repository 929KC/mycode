package com.kc.Servlet;


import com.kc.dao.StudentMapper;
import com.kc.dao.impl.StudentImpl;
import com.kc.model.domain.Student;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String classname = request.getParameter("select");
        StudentMapper query = new StudentImpl();
        List<Student> students = query.getStudents(classname);
        System.out.println(students);
    }
}
