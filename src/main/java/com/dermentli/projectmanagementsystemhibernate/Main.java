package com.dermentli.projectmanagementsystemhibernate;

import com.dermentli.projectmanagementsystemhibernate.service.ServiceFactory;

public class Main {

    private static final ServiceFactory serviceFactory = new ServiceFactory();

    public static void main(String[] args) {
//        System.out.println(serviceFactory.getProjectService().findProjectById(1L));
//        System.out.println(serviceFactory.getDeveloperService().findDeveloperById(4L));

//        System.out.println(serviceFactory.getProjectService().getDevSalariesOnProject(1L));
//        System.out.println(serviceFactory.getProjectService().getDevOnProject(1L));
        System.out.println(serviceFactory.getDeveloperService().getDevsByLanguage("Java"));
//        System.out.println(developerService.getDevsByLanguage("Middle"));
//        projectService.getProjectsInPreparedFormat();
    }
}
