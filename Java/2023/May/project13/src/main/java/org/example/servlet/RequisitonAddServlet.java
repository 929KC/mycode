package org.example.servlet;


import org.example.utils.DbHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequisitonAddServlet")
public class RequisitonAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbHelp dbHelp = new DbHelp();
        String Td_guid=request.getParameter("Td_guid");
        String Bpl_guid=request.getParameter("Bpl_guid");
        String Dl_name=request.getParameter("Dl_name");
        String Area=request.getParameter("Area");
        String Std=request.getParameter("Std");
        String sql="insert into T_requisiton_no_tilth values(?,?,?,?,?)";
        try {
            int n=dbHelp.update(sql, new String[] {Td_guid,Bpl_guid,Dl_name,Area,Std});
        }catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("RequisitonServlet");
    }
}
