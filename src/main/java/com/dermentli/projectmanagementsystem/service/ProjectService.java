package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.ProjectDAOImpl;
import com.dermentli.projectmanagementsystem.domain.Project;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAOImpl projectDAOImpl;

    public Optional<Integer> getDevSalariesOnProject(Long projectId) {
        return projectDAOImpl.getDevSalariesOnProject(projectId);
    }

    public void getProjectsInPreparedFormat() { projectDAOImpl.getProjectsInPreparedFormat(); }
}
