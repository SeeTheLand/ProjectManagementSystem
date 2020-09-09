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

    public List<Developer> getListOfDevsOnProject (Integer projectId) throws SQLException {
        //получаем список ид разработчиков на проекте
        List<Integer> targetDevelopersIds = new ArrayList<>();
        Optional<DevelopersProjects> developersProjects = jdbcDevelopersProjectsDAO.findById(projectId);
        List<Developer> list = null;
        return list;
    }

//    public List<Developer> getListOfJavaDevs () throws SQLException {
//        return developerDAO.processQueryListOfJavaDevs();
//    }
//
//    public List<Developer> getListOfMidDevs () throws SQLException {
//        return developerDAO.processQueryListOfMidDevs();
//    }


}
