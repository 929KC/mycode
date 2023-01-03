package com.kc.jsp.controller;

import com.kc.jsp.mapper.T_flow_step_defMapper;
import com.kc.jsp.mapper.impl.T_flow_step_defImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/9 9:52
 * @description:
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String step_id = request.getParameter("id");
        if (step_id == null || step_id.equals("")) {
            response.sendRedirect("error.html");
            return ;
        }
        int id = Integer.parseInt(step_id);
        T_flow_step_defMapper t = new T_flow_step_defImpl();
        int flag = t.delete(id);
        if (flag == 0) {
            response.sendRedirect("error.html");
        } else {
            response.sendRedirect("flow_def.html");
        }
    }
}
