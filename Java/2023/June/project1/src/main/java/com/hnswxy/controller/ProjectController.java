package com.hnswxy.controller;

import com.hnswxy.pojo.Project;
import com.hnswxy.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProjectController {
    //将ProjectService注入到controller中
    @Autowired
    private ProjectService projectService;
    @RequestMapping("/projectList")
    public ModelAndView queryProject(){
        System.out.println("sdf");
      List<Project> list =  projectService.queryProject();
      ModelAndView mv = new ModelAndView();
      mv.setViewName("project_list.jsp");  //展示页面
        mv.addObject("list",list);
        return mv;
    }
    @RequestMapping("/add")
    public ModelAndView addProject(HttpServletRequest request){
        System.out.println("sdf");
        ModelAndView mv=new ModelAndView();
        String projectId=request.getParameter("projectId");
        String projectName=request.getParameter("projectName");
        String deputyName=request.getParameter("deputyName");
        String telephone=request.getParameter("telephone");
        String addr=request.getParameter("addr");
        Project p=new Project();
        p.setProjectId(projectId);
        p.setProjectName(projectName);
        p.setDeputyName(deputyName);
        p.setTelephone(telephone);
        p.setAddr(addr);
        projectService.addProject(p);
        System.out.println("dsgsg");
        mv.setViewName("/projectList");
        return mv;
    }
    @RequestMapping("/update")
    public ModelAndView updateProject(HttpServletRequest request){
        ModelAndView mv=new ModelAndView();
        String projectId=request.getParameter("projectId");
        String projectName=request.getParameter("projectName");
        String deputyName=request.getParameter("deputyName");
        String telephone=request.getParameter("telephone");
        String addr=request.getParameter("addr");
        Project p=new Project();
        p.setProjectId(projectId);
        p.setProjectName(projectName);
        p.setDeputyName(deputyName);
        p.setTelephone(telephone);
        p.setAddr(addr);
        projectService.updateProject(p);
        mv.setViewName("/projectList");
        return mv;
    }
    @GetMapping("/delete")
    public ModelAndView deleteProject(HttpServletRequest request){
        System.out.println("dsgsg");
        ModelAndView mv=new ModelAndView();
        String projectId=request.getParameter("projectId");
        projectService.deleteProject(projectId);
        mv.setViewName("/projectList");
        return mv;
    }
}
