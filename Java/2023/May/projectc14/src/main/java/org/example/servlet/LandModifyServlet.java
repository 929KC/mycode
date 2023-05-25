package org.example.servlet;

import org.example.bean.Land;
import org.example.untis.DbHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LandModifyServlet")
public class LandModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Land land = null;
        String guid = (String) request.getParameter("guid");
        DbHelp db = new DbHelp();
        String sql = "select * from T_land_offer_scheme where Bpl_guid = "+guid;
        ResultSet rs = db.query(sql, null);
        try {
            while(rs.next()) {
                String guid2 = rs.getString("Bpl_guid");
                String name = rs.getString("Unit_name");
                String area = rs.getString("Period1_area");
                String sumarea = rs.getString("Period1_sum_area");
                String inputer = rs.getString("Inputer");
                 land = new Land(guid2,name,area,sumarea,inputer);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getSession().setAttribute("land",land);
        request.getRequestDispatcher("updateOffer.jsp").forward(request,response);
    }
}
