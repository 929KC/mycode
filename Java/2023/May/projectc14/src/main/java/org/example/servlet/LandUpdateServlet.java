package org.example.servlet;



import org.example.untis.DbHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/LandUpdateServlet")
public class LandUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String guid = request.getParameter("guid");
        String name = request.getParameter("name");
        BigDecimal area = new BigDecimal(request.getParameter("area")) ;
        BigDecimal sumarea = new BigDecimal(request.getParameter("sumarea"));
        String inputer = request.getParameter("Inputer");
        DbHelp db = new DbHelp();
        try {
            Connection conn = db.getConnection();
            String sql = "update T_land_offer_scheme " +
                    "set Bpl_guid=?," +
                    " Unit_name=?,"+
                    " Period1_area=?," +
                    " Period1_sum_area=?," +
                    " Inputer=? where Bpl_guid = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,guid);
            ps.setString(2,name);
            ps.setBigDecimal(3,area);
            ps.setBigDecimal(4,sumarea);
            ps.setString(5,inputer);
            ps.setString(6,guid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("LandServlet");
    }
}
