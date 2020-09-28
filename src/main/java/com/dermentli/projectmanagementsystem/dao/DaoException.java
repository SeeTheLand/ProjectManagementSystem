package com.dermentli.projectmanagementsystem.dao;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
