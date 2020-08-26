package com.dermentli.projectmanagementsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO {
    final String URL = "jdbc:postgresql://localhost:5432/itcompany";
    final String username = "postgres";
    final String password = "Fedor7777777";

    abstract Connection setConnection(String URL, String username, String password) throws SQLException;

    abstract ResultSet processRequest(String query);

}
