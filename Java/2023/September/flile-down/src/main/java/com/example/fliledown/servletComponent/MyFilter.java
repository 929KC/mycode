package com.example.fliledown.servletComponent;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.xml.ws.WebFault;
import java.io.IOException;

@WebFilter(value = {"/oneFilter","/toLoginPage"})
//@Component
public class MyFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter 初始化了。。。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 执行了。。。。。。");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter 销毁了。。。。。。");
    }
}
