package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.datasource.MyDataSourceFactory;
import com.dermentli.projectmanagementsystem.domain.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDAOImplTest {

    private static final Logger logger = LogManager.getLogger();
    private static Connection connection;

    @BeforeAll
    public static void setup() throws SQLException {
        DataSource dataSource = MyDataSourceFactory.getMyPostrgresDataSource();
        connection = dataSource.getConnection();
        logger.info("connection retrieved");
    }

    @Test
    void add() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projects(name, latest_release_date, cost) VALUES ('New Cool Project', 2025, 580)");
            int addResult = preparedStatement.executeUpdate();
            assertEquals(1, addResult);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void addAll() {
    }

    @Test
    void getDevSalariesOnProject() {
    }

    @Test
    void getProjectsInPreparedFormat() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.id, p.name, p.latest_release_date, p.cost, count(developer_id) FROM projects p " +
                "RIGHT JOIN developers_projects dp on p.id = dp.project_id RIGHT JOIN developers d on dp.developer_id = d.id group by p.id, p.name, p.latest_release_date, p.cost");
        ResultSet resultSet = preparedStatement.executeQuery();
        final Map<Project, Integer> projects = new HashMap<>();
        while (resultSet.next()) {
            final Long id = resultSet.getLong(1);
            final String name = resultSet.getString(2);
            final Integer latest_release_date = resultSet.getInt(3);
            final BigDecimal cost = resultSet.getBigDecimal(4);
            final Integer count = resultSet.getInt(5);
            projects.put(new Project(id, name, latest_release_date, cost), count);
        }
        for (Map.Entry<Project, Integer> entry : projects.entrySet()) {
            if (entry.getKey().getId() == 4) {
                assertEquals(3, entry.getValue());
            }
        }
    }
}