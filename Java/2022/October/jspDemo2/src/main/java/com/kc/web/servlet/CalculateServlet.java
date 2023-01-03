package com.kc.web.servlet;

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

/**
 * @author 929KC
 * @date 2022/11/7 14:16
 * @description: 计算
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("calculate",webContext,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String select = request.getParameter("select");
        int result = 0;
        if (select.equals("+")) {
            result = add(num1, num2);
        }
        if (select.equals("/")) {
            result = div(num1, num2);
        }
        if (select.equals("*")) {
            result = mul(num1, num2);
        }
        if (select.equals("-")) {
            result = div(num1, num2);
        }
        WebContext webContext = new WebContext(request,response,getServletContext());
        ServletContext context = getServletContext();
        webContext.setVariable("num1",num1);
        webContext.setVariable("num2",num2);
        webContext.setVariable("result",result);
        TemplateEngine engine = (TemplateEngine)context.getAttribute("engine");
        engine.process("calculate",webContext,response.getWriter());
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}
