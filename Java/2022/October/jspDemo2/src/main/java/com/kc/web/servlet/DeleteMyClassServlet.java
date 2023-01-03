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


@WebServlet("/delete")
public class DeleteMyClassServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        MyClassMapper mcm = new MyClassImpl();
        if (request.getParameter("id")!=null) {
          mcm.deleteMyClasses(Integer.valueOf(request.getParameter("id")));
        }
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        List<MyClass> list = mcm.getMyClasses();
        webContext.setVariable("myclasses",list);
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("task2",webContext,response.getWriter());
    }

}
