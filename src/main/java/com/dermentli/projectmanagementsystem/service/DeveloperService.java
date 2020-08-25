package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.DeveloperDAO;
import com.dermentli.projectmanagementsystem.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public List<Developer> getListOfDevsOnProject (Integer projectId) {
        return developerDAO.processQueryListOfDevsOnProject(projectId);
    }

    public List<Developer> getListOfJavaDevs () {
        return developerDAO.processQueryListOfJavaDevs();
    }

    public List<Developer> getListOfMidDevs () {
        return developerDAO.processQueryListOfMidDevs();
    }


}
