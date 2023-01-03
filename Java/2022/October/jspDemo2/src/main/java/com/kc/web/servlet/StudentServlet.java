package com.kc.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.web.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/11/14 18:36
 * @description:
 */
@WebServlet("/addstudent")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Student student = new Student();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        String card = request.getParameter("card");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writeValueAsString(student));
    }
}
