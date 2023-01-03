package com.kc.shoping.controller;

import com.kc.shoping.mapper.UserMapper;
import com.kc.shoping.mapper.impl.UserImpl;
import com.kc.shoping.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/12 9:58
 * @description:
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserMapper userMapper = new UserImpl();
        String  name = request.getParameter("name");
        String trueName = request.getParameter("trueName");
        String cardId = request.getParameter("cardId");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String qqId = request.getParameter("qqId");
        UserVo userVo = new UserVo(name,trueName,cardId,email,telephone,qqId);
        userMapper.insetUser(userVo);
        response.sendRedirect("manageUser.html");
    }
}
