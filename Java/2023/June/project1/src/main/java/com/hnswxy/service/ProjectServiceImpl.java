package com.hnswxy.service;

import com.hnswxy.dao.ProjectMapper;
import com.hnswxy.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    //将projectMapper注入到service层中
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public List<Project> queryProject() {
        return projectMapper.queryProject();
    }

    @Override
    public void addProject(Project project) {
        projectMapper.addProject(project);
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateProject(project);
    }

    @Override
    public void deleteProject(String projectId) {
        projectMapper.deleteProject(projectId);
    }
}
