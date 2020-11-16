package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.datasource.MyDataSourceFactory;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
class DeveloperDAOImplTest {

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
    }

    @Test
    void remove() {
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
    void getDevelopersByProjectID() {
    }

    @Test
    void getDevelopersByLanguage() {
    }

    @Test
    void getDevelopersByLevel() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM developers d RIGHT JOIN developers_skills ds on d.id = " +
                "ds.developer_id RIGHT JOIN skills s on ds.skill_id = s.id WHERE s.level = 'Junior' LIMIT 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            assertEquals("Agata Brown", resultSet.getString("name"));
        }
    }
}