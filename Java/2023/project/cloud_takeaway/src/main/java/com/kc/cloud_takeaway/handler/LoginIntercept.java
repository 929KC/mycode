package com.kc.cloud_takeaway.handler;

import com.kc.cloud_takeaway.common.BaseContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
@Component
public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session!=null&&session.getAttribute("employee") != null) {
            BaseContextUtils.setCurrentId((Long)session.getAttribute("employee"));
            log.info("已经登陆");
            return true;
        }
        response.sendRedirect("/static/backend/page/login/login.html");
        return false;
    }
}
