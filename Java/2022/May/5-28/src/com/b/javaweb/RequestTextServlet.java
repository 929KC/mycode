package com.b.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-28 09:58
 */

public class RequestTextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("登录成功");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);

            String[] values = request.getParameterValues(key);
            System.out.print(key + "=");
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println();
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
        }

        String[] userName = request.getParameterValues("username");
        String[] pwd = request.getParameterValues("pwd");
        String[] interst = request.getParameterValues("interst");

        for (String s : userName) {
            System.out.println(s);
        }

        for (String s : pwd) {
            System.out.println(s);
        }

        for (String s : interst) {
            System.out.println(s);
        }

        String username1 = request.getParameter("username");
        String pwd1=request.getParameter("pwd");
        String [] interests=request.getParameterValues("interst");
        System.out.println(username1);
        System.out.println(pwd1);
        for (String interest : interests) {
            System.out.println(interest);
        }
    }
}
