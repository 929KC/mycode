package org.example.servlet;



import org.example.bean.Enterprise;
import org.example.untis.DbHelp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EnterpriseServlet")
public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        DbHelp db = new DbHelp();
        String sql = "select * from enterpriseInfo";
        ResultSet rs = db.query(sql, null);
        List<Enterprise> list = new ArrayList<Enterprise>();
        try {
            while(rs.next()) {
                String entId = rs.getString("entId");
                String entName = rs.getString("entName");
                String beginDate = rs.getString("beginDate");
                String addr = rs.getString("addr");
                String regCapital = rs.getString("regCapital");
                Enterprise e = new Enterprise(entId,entName,beginDate,addr,regCapital);
                list.add(e);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getSession().setAttribute("list", list);
        response.sendRedirect("enterrpriseList.jsp");
    }

}
