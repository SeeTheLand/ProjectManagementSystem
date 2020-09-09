package com.dermentli.projectmanagementsystem.dao;

import java.sql.SQLException;

public class ExceptionDAO extends RuntimeException {
    public ExceptionDAO(String message, SQLException e) {
        super(message);
    }
}
