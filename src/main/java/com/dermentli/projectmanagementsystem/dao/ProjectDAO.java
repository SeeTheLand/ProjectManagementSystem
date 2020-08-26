package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends GenericDAO {

    public Integer processQueryForProjDevSalary (Integer projectId) throws SQLException {
        return getProjDevSalary("SELECT sum(salary)" +
                "FROM developers d" +
                "         INNER JOIN developers_projects dp on d.id = dp.developer_id" +
                "         INNER JOIN  projects p on dp.project_id = p.id " +
                "WHERE p.id = " + projectId + ";");
    }

    public List<Project> processQueryForProjDevNumber () throws SQLException {
        return getProjectInfo("SELECT latest_release_date, p.name, count(developer_id)\n" +
                "FROM projects p\n" +
                "INNER JOIN developers_projects dp on p.id = dp.project_id\n" +
                "INNER JOIN developers d on dp.developer_id = d.id\n" +
                "group by latest_release_date, p.name;");
    }


    @Override
    Connection setConnection(String URL, String username, String password) throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }

    List<Project> getProjectInfo (String query) throws SQLException {
        try (Connection connection = setConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
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


    Integer getProjDevSalary(String query) throws SQLException {
        try (Connection connection = setConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
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
}
