package com.dermentli.projectmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    final String URL = "jdbc:postgresql://localhost:5432/itcompany";
    final String username = "postgres";
    final String password = "Fedor7777777";
    Connection connection;

    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}
