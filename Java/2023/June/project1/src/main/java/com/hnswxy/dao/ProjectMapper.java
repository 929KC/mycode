package com.hnswxy.dao;

import com.hnswxy.pojo.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProjectMapper {
    //查询
    public List<Project> queryProject();
    //添加
    public void addProject(Project project);
    //修改
    public void updateProject(Project project);
    //删除
    public void deleteProject(String projectId);
}
