package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.DevelopersProjects;

public interface DevelopersProjectsDAO extends DAO<DevelopersProjects> {
    String TABLE_NAME = "developers_projects";
    String INSERT = "INSERT INTO " + TABLE_NAME + "(project_id, developer_id) VALUES (?, ?)";
    String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE project_id=?";
    String REMOVE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE project_id=?";
    String CLEAR_TABLE = "DELETE FROM " + TABLE_NAME;
    String FIND_ALL = "SELECT * FROM " + TABLE_NAME;
}
