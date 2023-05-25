package org.example.servlet;



import org.example.untis.DbHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/EnterpriseAddServlet")
public class EnterpriseAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        DbHelp dbHelp = new DbHelp();
        String entId = (String)request.getParameter("t1");
        String entName = (String)request.getParameter("t2");
        try {
            Connection conn = dbHelp.getConnection();
            String sql = "insert into enterpriseInfo(entId,entName) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,entId);
            ps.setString(2,entName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("EnterpriseServlet");
    }
}
