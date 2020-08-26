package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.ProjectDAO;
import com.dermentli.projectmanagementsystem.domain.Project;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;

    public Integer getProjDevSalary(Integer projectId) throws SQLException {
        return projectDAO.processQueryForProjDevSalary(projectId);
    }

    public List<Project> getProjDevNumber() throws SQLException {
        return projectDAO.processQueryForProjDevNumber();
    }
}
