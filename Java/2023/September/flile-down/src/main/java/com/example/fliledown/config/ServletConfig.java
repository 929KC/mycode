package com.example.fliledown.config;

import com.example.servletComponent.MyFilter;
import com.example.servletComponent.MyListener;
import com.example.servletComponent.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

//@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean<MyServlet> myServletServletRegistrationBean =
                new ServletRegistrationBean<>(myServlet,"/oneServlet");
        return myServletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/oneFilter"));
        return filterFilterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(myListener);
        return registrationBean;
    }

}
