package org.example.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dao.TaskDao;
import org.example.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
    //数据处理类
    private TaskDao dao = new TaskDao();
    //工具类
    private Gson gson = new Gson();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setCharacterEncoding("UTF-8");
        //响应格式
        response.setContentType("text/json");
        //允许跨域，后台与前台的地址要在同一空间
        response.setHeader("Access-Control-Allow-Origin", "*");
        String action = request.getParameter("ac");
        if(action!=null&& action.equalsIgnoreCase("one")){
            String code = request.getParameter("code");
            if(code!=null && !code.equalsIgnoreCase("")){
                //查任务
                Task task = dao.getTaskByCodeAndPhone(code.trim());
                //输出
                response.getWriter().write(gson.toJson(task));
            }
        }else if (action!=null&&action.equalsIgnoreCase("list")){
            System.out.println("aaa");
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            response.getWriter().write(gson.toJson(dao.getTaskList()));
        }
    }
}
