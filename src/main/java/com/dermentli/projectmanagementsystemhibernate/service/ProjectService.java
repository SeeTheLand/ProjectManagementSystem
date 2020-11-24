package com.dermentli.projectmanagementsystemhibernate.service;

import com.dermentli.projectmanagementsystemhibernate.dao.ProjectDAO;
import com.dermentli.projectmanagementsystemhibernate.domain.Developer;
import com.dermentli.projectmanagementsystemhibernate.domain.Project;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;

    public Project findProjectById(Long id) {
        return projectDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found for id " + id));
    }

    public List<Developer> getDevOnProject(Long id) {
        Project project = projectDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found for id " + id));
        return project.getDevelopers();
    }

    public BigDecimal getDevSalariesOnProject(Long id) {
        Project project = projectDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found for id " + id));
        List<Developer> developers = project.getDevelopers();
        return developers.stream()
                .map(Developer::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
