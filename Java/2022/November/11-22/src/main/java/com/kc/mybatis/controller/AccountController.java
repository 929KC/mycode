package com.kc.mybatis.controller;

import com.kc.mybatis.service.AccountService;
import com.kc.mybatis.service.AccountServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 929KC
 * @date 2022/11/21 20:37
 * @description:
 */
@WebServlet("/transfer")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        PrintWriter writer = response.getWriter();
        double money = Double.parseDouble(request.getParameter("money"));
        accountService.transfer(fromActno, toActno, money);
        writer.print("转账成功");
    }
}
