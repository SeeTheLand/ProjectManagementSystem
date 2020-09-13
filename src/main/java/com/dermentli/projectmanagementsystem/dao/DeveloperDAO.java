package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Developer;

public interface DeveloperDAO extends DAO<Developer, Long> {
    String TABLE_NAME = "developers";
    String TABLE_PROJECTS = "projects";
    String TABLE_DEV_PROJ = "developers_projects";
    String INSERT = "INSERT INTO " + TABLE_NAME + "(name, age, gender, salary) VALUES (?, ?, ?, ?)";
    String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
    String REMOVE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
    String CLEAR_TABLE = "DELETE FROM " + TABLE_NAME;
    String FIND_ALL = "SELECT * FROM " + TABLE_NAME;
    String GET_DEVELOPERS_ON_PROJECT = "SELECT * FROM developers d INNER JOIN " + TABLE_DEV_PROJ + " dp on d.id = dp.developer_id INNER JOIN  " + TABLE_PROJECTS + " p on dp.project_id = p.id WHERE p.id = ?";
    String GET_LANGUAGE_DEVELOPERS = ""
}
