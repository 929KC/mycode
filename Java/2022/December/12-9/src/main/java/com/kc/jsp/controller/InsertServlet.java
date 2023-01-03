package com.kc.jsp.controller;

import com.kc.jsp.mapper.T_flow_step_defMapper;
import com.kc.jsp.mapper.impl.T_flow_step_defImpl;
import com.kc.jsp.model.T_flow_step_def;
import com.kc.jsp.vo.T_flow_step_defVo;
import lombok.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/9 9:37
 * @description:
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        T_flow_step_defMapper t = new T_flow_step_defImpl();
        String step_name = request.getParameter("name");
        String time = request.getParameter("limitTime");
        int limitTime = Integer.parseInt(time);
        if (step_name == null || request.getParameter("limitTime") == null || step_name.equals("") || time.equals("")
        ) {
            response.sendRedirect("error.html");
            return ;
        }
        String desc = request.getParameter("desc");
        String URL = request.getParameter("URL");
        if (desc != null && URL != null && !desc.equals("") && !URL.equals("")) {
            T_flow_step_defVo t_flow_step_defVo = new T_flow_step_defVo(step_name, limitTime, desc, URL);
            int flag = t.insert(t_flow_step_defVo);
            if (flag == 0) {
                response.sendRedirect("error.html");
                return ;
            } else {
                response.sendRedirect("flow_def.html");
                return ;
            }
        }
    }
}
