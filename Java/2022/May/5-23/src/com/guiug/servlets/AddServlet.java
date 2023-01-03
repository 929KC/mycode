package com.guiug.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-22 20:18
 */
//@WebServlet("/add")
public class AddServlet extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fname=req.getParameter("fname");
        String privceStr=req.getParameter("price");
        Integer price=Integer.parseInt(privceStr);
        String fcountStr=req.getParameter("fcount");
        Integer fcount=Integer.parseInt(fcountStr);
        String remark=req.getParameter("remark");
        System.out.println("fname "+fname);
        System.out.println("price "+price);
        System.out.println("fcount "+fcount);
        System.out.println("remark "+remark);
    }
}
