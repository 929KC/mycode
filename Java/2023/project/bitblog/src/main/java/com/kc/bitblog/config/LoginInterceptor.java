package com.kc.bitblog.config;

import com.kc.bitblog.common.AppVariable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session!=null&&session.getAttribute(AppVariable.USER_SESSION_KEY)!=null) {
            return true;
        }
        response.sendRedirect("/login.html");
        return false;
    }
}
