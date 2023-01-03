package com.kc.web.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ThymeleafConfig implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("初始化完毕!");
        ServletContext context = servletContextEvent.getServletContext();
        // 初始化
        TemplateEngine engine = new TemplateEngine();
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(context);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("utf-8");
        engine.setTemplateResolver(resolver);
        // 把 engine 放到了 ServletContext 中 后面的Servlet程序就可以使用
        context.setAttribute("engine",engine);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
