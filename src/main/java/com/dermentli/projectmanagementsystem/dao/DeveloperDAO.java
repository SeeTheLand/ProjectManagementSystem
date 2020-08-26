package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDAO extends GenericDAO{

    public List<Developer> processQueryListOfDevsOnProject (Integer projectId) throws SQLException {
        ResultSet resultSet = processRequest("SELECT * " +
                "FROM developers d " +
                "         INNER JOIN developers_projects dp on d.id = dp.developer_id " +
                "         INNER JOIN  projects p on dp.project_id = p.id " +
                "WHERE p.id = " + projectId + ";");
        return getDeveloperInfo(resultSet);
    }

    public List<Developer> processQueryListOfJavaDevs () throws SQLException {
        ResultSet resultSet = processRequest("SELECT *\n" +
                "FROM developers d\n" +
                "    INNER JOIN developers_skills ds on d.id = ds.developer_id\n" +
                "    INNER JOIN languages l on ds.language_id = l.id\n" +
                "WHERE l.name = 'Java';");
        return getDeveloperInfo(resultSet);
    }

    public List<Developer> processQueryListOfMidDevs () throws SQLException {
        ResultSet resultSet = processRequest("SELECT *\n" +
                "FROM developers d\n" +
                "    INNER JOIN developers_skills ds on d.id = ds.developer_id\n" +
                "    INNER JOIN skills s on ds.skill_id = s.id\n" +
                "WHERE s.level = 'Middle';");
        return getDeveloperInfo(resultSet);
    }

    @Override
    Connection setConnection(String URL, String username, String password) throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }

    @Override
    ResultSet processRequest(String query) {
        try (Connection connection = setConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    List<Developer> getDeveloperInfo (ResultSet resultSet) throws SQLException {
        List<Developer> developers = new ArrayList<>();
        while (resultSet.next()) {
            Developer developer = new Developer();
            developer.setId(resultSet.getLong("id"));
            developer.setName(resultSet.getString("name"));
            developer.setAge(resultSet.getInt("age"));
            developer.setGender(resultSet.getString("gender"));
            developer.setSalary(resultSet.getInt("salary"));
            developers.add(developer);
        }
        return developers;
    }

}
