package servlet;

import utils.DbHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/addProjectServlet")
public class ProjectAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        DbHelp dbHelp = new DbHelp();
        String projectId = (String)request.getParameter("projectId");
        String projectName = (String)request.getParameter("projectName");
        String apply = (String)request.getParameter("apply");

        try {
            Connection conn = dbHelp.getConnection();
            String sql = "insert into t_project(projectId,projectName) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,projectId);
            ps.setString(2,projectName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("ProjectServlet?type=query");
    }
}
