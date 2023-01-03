package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-18 19:37
 */
@Controller
public class ScopeController {
    @RequestMapping("/testScope")
    public String getVlues(HttpServletRequest request) {
        request.setAttribute("username", "黄茂荣");
        return "success";
    }

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/testModeAndView")
    public ModelAndView getValue() {
        //处理模型数据,即向请求域中添加数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", "叶子秋");
        //设置视图
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testModel")
    public String testModel(Model m) {
        m.addAttribute("username", "叶秋涵");
        System.out.println(m.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, String> map) {
        map.put("username", "叶子秋");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap map) {
        map.addAttribute("username", "贾宝玉");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpServletRequest session) {
        session.setAttribute("username","林黛玉");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpServletRequest session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("username","薛宝钗");
        return "success";
    }
}
