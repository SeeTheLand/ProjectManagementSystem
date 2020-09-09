package com.dermentli.projectmanagementsystem.service;

import com.dermentli.projectmanagementsystem.dao.JdbcProjectDAO;
import com.dermentli.projectmanagementsystem.domain.Project;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final JdbcProjectDAO jdbcProjectDAO;

//    public Integer getProjDevSalary(Integer projectId) throws SQLException {
//        return jdbcProjectDAO.processQueryForProjDevSalary(projectId);
//    }
//
//    public List<Project> getProjDevNumber() throws SQLException {
//        return jdbcProjectDAO.processQueryForProjDevNumber();
//    }
}
