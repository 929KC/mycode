package com.kc.web.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/11/7 14:41
 * @description:
 */

@WebServlet("/circle")
public class CircleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("circle",webContext,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        double radius = Integer.parseInt(request.getParameter("radius"));
        double area = Math.PI*Math.pow(radius,2);
        double perimeter = 2*Math.PI*radius;
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        webContext.setVariable("radius",radius);
        webContext.setVariable("area",area);
        webContext.setVariable("perimeter",perimeter);
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("circle",webContext,response.getWriter());

    }
}
