package com.dermentli.projectmanagementsystem.error;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
