package org.example.servlet;



import org.example.bean.t_ministry_approve;
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

@WebServlet("/t_ministry_approveServlet")
public class t_ministry_approveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        DbHelp dbHelp=new DbHelp();
        if(type.equals("query")) {//查询所以信息列表
            String sql="select * from T_ministry_approve";
            ResultSet rs=dbHelp.query(sql, null);
            List<t_ministry_approve> list=new ArrayList<t_ministry_approve>();
            try {
                while(rs.next()) {
                    String Mi_guid=rs.getString("Mi_guid");
                    String Proj_guid=rs.getString("Proj_guid");
                    String Approve_symbo =rs.getString("Approve_symb");
                    String Approve_time =rs.getString("Approve_time");
                    String Submit_time=rs.getString("Submit_time");
                    t_ministry_approve p=new t_ministry_approve(Mi_guid,Proj_guid,Approve_symbo,Approve_time,Submit_time);
                    list.add(p);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.getSession().setAttribute("list", list);
            response.sendRedirect("listApprove.jsp");
        }else if(type.equals("delete")) {//添加记录
            String Mi_guid=request.getParameter("Mi_guid");
            String sql="DELETE FROM T_ministry_approve WHERE Mi_guid=?";
            dbHelp.update(sql, new Object[] {Mi_guid});
            //进入信息页面
            response.sendRedirect("t_ministry_approveServlet?type=query");
        }
    }
}
