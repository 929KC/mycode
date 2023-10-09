package com.example.securitydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class FilmeController {
    // 影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("path") String path) {
        return "detail/" + type + "/" + path;
    }

    //用户登录
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }

    //获取用户信息
    @GetMapping("/getuserBySession")
    @ResponseBody
    public void getUser(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            SecurityContextImpl attribute =
                    (SecurityContextImpl) session.getAttribute(element);
            System.out.println("element: " + element);
            System.out.println("attribute: " + attribute);
            Authentication authentication = attribute.getAuthentication();
            UserDetails principal = (UserDetails) authentication.getPrincipal();
            System.out.println(principal);
            System.out.println("username: " + principal.getUsername());
        }
    }


}
