package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Developer;

public interface DeveloperDAO extends DAO<Developer> {
    String TABLE_NAME = "developers";
    String INSERT = "INSERT INTO " + TABLE_NAME + "(name, age, gender, salary) VALUES (?, ?, ?, ?)";
    String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
    String REMOVE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
    String CLEAR_TABLE = "DELETE FROM " + TABLE_NAME;
    String FIND_ALL = "SELECT * FROM " + TABLE_NAME;
}
