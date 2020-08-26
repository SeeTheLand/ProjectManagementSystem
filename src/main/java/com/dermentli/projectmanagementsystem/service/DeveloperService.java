package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.DeveloperDAO;
import com.dermentli.projectmanagementsystem.domain.Developer;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public List<Developer> getListOfDevsOnProject (Integer projectId) throws SQLException {
        return developerDAO.processQueryListOfDevsOnProject(projectId);
    }

    public List<Developer> getListOfJavaDevs () throws SQLException {
        return developerDAO.processQueryListOfJavaDevs();
    }

    public List<Developer> getListOfMidDevs () throws SQLException {
        return developerDAO.processQueryListOfMidDevs();
    }


}
