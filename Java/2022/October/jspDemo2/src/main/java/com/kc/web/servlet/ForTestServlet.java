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

@WebServlet("/forTest")
public class ForTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String message = req.getParameter("message");
        WebContext webContext = new WebContext(req,resp,getServletContext());
        webContext.setVariable("message",message);
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine) context.getAttribute("engine");
        engine.process("hello",webContext, resp.getWriter());
    }
}
