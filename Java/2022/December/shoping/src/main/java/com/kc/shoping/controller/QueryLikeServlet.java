package com.kc.shoping.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.shoping.mapper.ProductMapper;
import com.kc.shoping.mapper.impl.productImpl;
import com.kc.shoping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/12/13 20:18
 * @description:
 */
@WebServlet("/queryLike")
public class QueryLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        ProductMapper productMapper = new productImpl();
        String name = request.getParameter("name");
        Product product = productMapper.queryProductLike(name);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(product));
    }
}
