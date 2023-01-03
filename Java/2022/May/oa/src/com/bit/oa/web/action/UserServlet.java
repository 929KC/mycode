package com.bit.oa.web.action;

import com.bit.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-01 15:53
 */
@WebServlet("/login/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            conn= DBUtil.getConnection();
            String sql="select *from t_user where username=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next()){
                flag=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.close(conn,ps,rs);
        }
        if(flag){
            //登录成功
            //重定向
            response.sendRedirect( request.getContextPath()+"/dept/list");
        }else{
            //登录失败
        }  response.sendRedirect( request.getContextPath()+"/error.jsp");
    }
}
