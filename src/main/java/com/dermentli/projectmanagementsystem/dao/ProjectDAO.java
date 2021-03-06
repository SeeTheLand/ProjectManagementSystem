package com.dermentli.projectmanagementsystem.dao;

import com.dermentli.projectmanagementsystem.domain.Project;

public interface ProjectDAO extends DAO<Project, Long> {
    String TABLE_NAME = "projects";
    String TABLE_DEVELOPERS = "developers";
    String TABLE_DEV_PROJ = "developers_projects";
    String INSERT = "INSERT INTO " + TABLE_NAME + "(name, latest_release_date, cost) VALUES (?, ?, ?)";
    String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
    String REMOVE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE id=?";
    String CLEAR_TABLE = "DELETE FROM " + TABLE_NAME;
    String FIND_ALL = "SELECT * FROM " + TABLE_NAME;
    String SALARY_SUM_ON_PROJECT = "SELECT sum(salary) FROM " + TABLE_DEVELOPERS + " d INNER JOIN " + TABLE_DEV_PROJ + " dp on d.id = dp.developer_id INNER JOIN  " + TABLE_NAME + " p on dp.project_id = p.id WHERE p.id = ?";
    String PROJECTS_WITH_EXTRA_FIELDS = "SELECT p.id, p.name, p.latest_release_date, p.cost, count(developer_id) FROM " + TABLE_NAME + " p RIGHT JOIN " + TABLE_DEV_PROJ + " dp on p.id = dp.project_id RIGHT JOIN " + TABLE_DEVELOPERS + " d on dp.developer_id = d.id group by p.id, p.name, p.latest_release_date, p.cost;";
}
