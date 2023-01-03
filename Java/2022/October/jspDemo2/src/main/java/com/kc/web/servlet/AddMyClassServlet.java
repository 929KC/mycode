package com.kc.web.servlet;


import com.kc.web.dao.MyClassMapper;
import com.kc.web.dao.impl.MyClassImpl;
import com.kc.web.model.MyClass;
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


@WebServlet("/add")
public class AddMyClassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        MyClassMapper mcm = new MyClassImpl();
        List<MyClass> myClasses = mcm.getMyClasses();
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        webContext.setVariable("myclasses",myClasses);
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("task",webContext,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int    id =Integer.valueOf(request.getParameter("id"));
        String  classname = request.getParameter("classname");
        String  teacher = request.getParameter("teacher");
        String  professional = request.getParameter("professional");
        MyClassMapper mcm = new MyClassImpl();
        mcm.addMyClass(id,classname,teacher,professional);
        List<MyClass> myClasses = mcm.getMyClasses();
        WebContext webContext = new WebContext(request,response,getServletContext());
        webContext.setVariable("myclasses",myClasses);
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("task",webContext,response.getWriter());
    }
}
