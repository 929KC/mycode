package com.hnswxy.service;

import com.hnswxy.pojo.Project;

import java.util.List;

public interface ProjectService {
    //查询
    public List<Project> queryProject();
    //添加
    public void addProject(Project project);
    //修改
    public void updateProject(Project project);
    //删除
    public void deleteProject(String projectId);
}
