package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.ProjectDAO;
import com.dermentli.projectmanagementsystem.domain.Project;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;

    public Integer getProjDevSalary(Integer projectId) {
        return projectDAO.processQueryForProjDevSalary(projectId);
    }

    public List<Project> getProjDevNumber() {
        return projectDAO.processQueryForProjDevNumber();
    }
}
