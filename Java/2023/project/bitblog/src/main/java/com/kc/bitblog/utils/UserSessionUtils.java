package com.kc.bitblog.utils;

import com.kc.bitblog.common.AppVariable;
import com.kc.bitblog.model.domain.Userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSessionUtils {

    public static Userinfo getUserinfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null&session.getAttribute(AppVariable.USER_SESSION_KEY)!=null) {
            return (Userinfo) session.getAttribute(AppVariable.USER_SESSION_KEY);
        }
        return null;
    }
}
