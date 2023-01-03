package com.kc.blog.controller;

import com.kc.blog.dao.BlogMapper;
import com.kc.blog.dao.impl.BlogImpl;
import com.kc.blog.model.Blog;
import com.kc.blog.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 929KC
 * @date 2022/11/30 22:34
 * @description:
 */
@WebServlet("/blog_delete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.setStatus(403);
            response.getWriter().write("用户未登录");
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.setStatus(403);
            response.getWriter().write("用户未登录");
            return;
        }
        int  blogId = Integer.parseInt(request.getParameter("blogId"));
        BlogMapper blogMapper = new BlogImpl();
        Blog blog =  blogMapper.getBlogById(blogId);
        if (blog==null) {
            response.getWriter().write("博客不存在");
            response.setStatus(403);
            return;
        }
        if (blog.getUserId()!= user.getUserId()) {
            response.setStatus(403);
            response.getWriter().write("你无法删除别人的文章");
            return;
        }
        blogMapper.deleteBlog(blogId);
        response.sendRedirect("blog_list.html");
    }
}
