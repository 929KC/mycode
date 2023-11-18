package org.example.servlet;


import com.google.gson.Gson;
import org.example.dao.FittingDao;
import org.example.model.Fitting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/FittingServlet")
public class FittingServlet extends HttpServlet {
    private FittingDao fittingDao = new FittingDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setCharacterEncoding("UTF-8");//响应格式
        response.setContentType("text/json");
        String action = request.getParameter("sc");
        if (action!=null&&action.equalsIgnoreCase("list")) {
            //查询到所有的配件
            List<Fitting> fittingList = fittingDao.getFittingList();
            //转GSON
            Gson gson = new Gson();
            String json = gson.toJson(fittingList);//设置编码
            //输出
            response.getWriter().write(json);
        }else if (action!=null&&action.equalsIgnoreCase("one")) {
            String fit_id = request.getParameter("fit_id");
            if (fit_id!=null) {
                Fitting fitting=fittingDao.getFitting(Integer.parseInt(fit_id.trim()));//转GSON
                Gson gson=new Gson();
                String json = gson.toJson(fitting);
                response.getWriter().write(json);
            }
        }

    }
}
