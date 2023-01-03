package com.kc.web.servlet;

import com.kc.web.dao.StudentMapper;
import com.kc.web.dao.impl.StudentImpl;
import com.kc.web.model.Student;
import lombok.SneakyThrows;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String classname = request.getParameter("select");
        StudentMapper query = new StudentImpl();
        List<Student> list = query.getStudents(classname);
        WebContext webContext = new WebContext(request,response,getServletContext());
        webContext.setVariable("students",list);
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("Demo",webContext,response.getWriter());
    }
}
