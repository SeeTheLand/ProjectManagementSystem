package com.dermentli.projectmanagementsystem.datasource;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MyDataSourceFactoryTest {

    @Test
    void testMyPostrgresDataSource() throws SQLException {
        DataSource dataSource;
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        dataSource = MyDataSourceFactory.getMyPostrgresDataSource();
        try {
            assert dataSource != null;
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM developers WHERE id = '1'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                assertEquals("Agata Brown", resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}