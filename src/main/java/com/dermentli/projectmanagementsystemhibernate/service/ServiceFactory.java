package com.dermentli.projectmanagementsystemhibernate.service;

import com.dermentli.projectmanagementsystemhibernate.dao.DeveloperDAO;
import com.dermentli.projectmanagementsystemhibernate.dao.ProjectDAO;

public class ServiceFactory {

    public DeveloperService getDeveloperService() {
        return new DeveloperService(new DeveloperDAO());
    }

    public ProjectService getProjectService() {
        return new ProjectService(new ProjectDAO());
    }
}
