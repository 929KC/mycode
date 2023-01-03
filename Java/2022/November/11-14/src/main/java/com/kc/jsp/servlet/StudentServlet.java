package com.kc.jsp.servlet;


import com.kc.jsp.dao.StudentMapper;
import com.kc.jsp.dao.impl.StudentImpl;
import com.kc.jsp.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String card = request.getParameter("card");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        StudentMapper mapper = new StudentImpl();
        mapper.insert(new Student(id, gender, username, card, phone, address));
        List<Student> list = mapper.queryAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("jstl.jsp").forward(request, response);
    }
}
