package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.JdbcDeveloperDAO;
import com.dermentli.projectmanagementsystem.dao.JdbcDevelopersProjectsDAO;
import com.dermentli.projectmanagementsystem.domain.Developer;
import com.dermentli.projectmanagementsystem.domain.DevelopersProjects;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DeveloperService {

    private final JdbcDeveloperDAO jdbcDeveloperDAO;
    private final JdbcDevelopersProjectsDAO jdbcDevelopersProjectsDAO;

    public Optional<Developer> getListOfDevsOnProject (Long projectId) {
        return jdbcDeveloperDAO.getDeveolopersByProjectID(projectId);
    }

//    public List<Developer> getListOfJavaDevs () throws SQLException {
//        return developerDAO.processQueryListOfJavaDevs();
//    }
//
//    public List<Developer> getListOfMidDevs () throws SQLException {
//        return developerDAO.processQueryListOfMidDevs();
//    }


}
