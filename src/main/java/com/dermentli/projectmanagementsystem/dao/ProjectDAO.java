package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends GenericDAO {

    public Integer processQueryForProjDevSalary (Integer projectId) {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT sum(salary)" +
                    "FROM developers d" +
                    "         INNER JOIN developers_projects dp on d.id = dp.developer_id" +
                    "         INNER JOIN  projects p on dp.project_id = p.id " +
                    "WHERE p.id = " + projectId + ";");
            Project project = new Project();
            while (resultSet.next()) {
                project.setSumSalary(resultSet.getInt("sum"));
            }
            return project.getSumSalary();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Project> processQueryForProjDevNumber () {
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT latest_release_date, p.name, count(developer_id)\n" +
                    "FROM projects p\n" +
                    "INNER JOIN developers_projects dp on p.id = dp.project_id\n" +
                    "INNER JOIN developers d on dp.developer_id = d.id\n" +
                    "group by latest_release_date, p.name;");
            List<Project> projects  = new ArrayList<>();
            while (resultSet.next()) {
                Project project = new Project();
                project.setLatestReleaseDate(resultSet.getInt("latest_release_date"));
                project.setName(resultSet.getString("name"));
                project.setNumberOfDevelopers(resultSet.getInt("count"));
                projects.add(project);
            }
            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



}
