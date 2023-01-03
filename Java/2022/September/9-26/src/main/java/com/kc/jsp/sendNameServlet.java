package com.kc.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendName")
public class sendNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String[] name = request.getParameterValues("username");
        if (name.length==0||name[0].equals("")) {
            response.sendRedirect("inputName.jsp");
        }else{

            request.setAttribute("username",name.length);
            request.getRequestDispatcher("people.jsp").forward(request,response);
        }
    }
}
