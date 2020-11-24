package com.dermentli.projectmanagementsystemhibernate.dao;

import com.dermentli.projectmanagementsystemhibernate.domain.Project;

public class ProjectDAO extends GenericDAO<Project, Long> {

    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }


}
