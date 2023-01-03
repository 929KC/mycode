package com.bit.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-25 15:27
 */
@WebServlet("/test5")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn =null;
        PreparedStatement ps = null;
       ResultSet rs = null;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("Utf-8");
        String user = request.getParameter("user");
        boolean flag = false;
        PrintWriter out = response.getWriter();
        try {
            conn  = DBUtils.getConnection();
            String sql = "select id,name from t_user where name=?";
            ps= conn.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()) {
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtils.close(conn,ps,rs);
        if(flag){
            out.println("<font color='green'>登录成功</font>");
        }else{
            out.println("<font color='red'>登录失败</font>");
        }
    }
}
