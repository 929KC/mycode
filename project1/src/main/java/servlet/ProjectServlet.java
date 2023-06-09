package servlet;

import bean.Project;
import utils.DbHelp;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		DbHelp db = new DbHelp();
		if(type.equals("query")) {
			//��ѯ��sql���
			String sql = "select * from t_project";
			ResultSet rs = db.query(sql, null);
			List<Project> list = new ArrayList<Project>();
			try {
				while(rs.next()) {
					String projectId = rs.getString("projectId");
					String projectName = rs.getString("projectName");
					String deputyName = rs.getString("deputyName");
					String telephone = rs.getString("telephone");
					String addr = rs.getString("addr");
					Project p = new Project(projectId,projectName,deputyName,telephone,addr);
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("list", list);
			response.sendRedirect("project_list.jsp");
		}
	}
}
