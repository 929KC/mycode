package org.example.servlet;



import org.example.bean.Requisiton;
import org.example.utils.DbHelp;

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


@WebServlet("/RequisitonServlet")
public class RequisitonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        DbHelp dbHelp=new DbHelp();
        String sql="select * from T_requisiton_no_tilth";
        ResultSet rs=dbHelp.query(sql, null);
        List<Requisiton> list=new ArrayList<Requisiton>();
        try {
            while(rs.next()) {
                String Td_guid=rs.getString("Td_guid");
                String Bpl_guid=rs.getString("Bpl_guid");
                String Dl_name =rs.getString("Dl_name");
                String Area =rs.getString("Area");
                String Std=rs.getString("Std");
                Requisiton r = new Requisiton(Td_guid,Bpl_guid,Dl_name,Area,Std);
                list.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getSession().setAttribute("list", list);
        response.sendRedirect("listRequisition.jsp");

    }
}
