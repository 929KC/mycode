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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LandServlet")
public class LandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        DbHelp db = new DbHelp();
        String sql = "select * from T_land_offer_scheme";
        ResultSet rs = db.query(sql, null);
        List<Land> list = new ArrayList<Land>();
        try {
            while(rs.next()) {
                String guid = rs.getString("Bpl_guid");
                String name = rs.getString("Unit_name");
                String area = rs.getString("Period1_area");
                String sumarea = rs.getString("Period1_sum_area");
                String inputer = rs.getString("Inputer");
                Land e = new Land(guid,name,area,sumarea,inputer);
                list.add(e);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getSession().setAttribute("list", list);
        response.sendRedirect("listOffer.jsp");
    }

}
