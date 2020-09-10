package com.dermentli.projectmanagementsystem;

import com.dermentli.projectmanagementsystem.dao.JdbcDeveloperDAO;
import com.dermentli.projectmanagementsystem.dao.JdbcDevelopersProjectsDAO;
import com.dermentli.projectmanagementsystem.dao.JdbcProjectDAO;
import com.dermentli.projectmanagementsystem.service.DeveloperService;
import com.dermentli.projectmanagementsystem.service.ProjectService;

import java.sql.SQLException;

public class  Main {

    private static final ProjectService projectService = new ProjectService(new JdbcProjectDAO());
    private static final DeveloperService developerService = new DeveloperService(new JdbcDeveloperDAO(), new JdbcDevelopersProjectsDAO());

    public static void main(String[] args) throws SQLException {
        developerService.getListOfDevsOnProject(1L);
//        System.out.println(projectService.getProjDevSalary(4));
//        System.out.println(developerService.getListOfDevsOnProject(4));
//        System.out.println(developerService.getListOfJavaDevs());
//        System.out.println(developerService.getListOfMidDevs());
//        System.out.println(projectService.getProjDevNumber());
    }

//    INSERT INTO projects(name, latest_release_date, cost) VALUES ('New Cool Project', 2025, 580);
//    INSERT INTO companies_projects(project_id, company_id) VALUES (16, 3);
//    INSERT INTO developers(name, age, gender, salary) VALUES ('Mark Newbie', 17, 'male', 450);
//    INSERT INTO developers_projects(project_id, developer_id) VALUES (1, 5);
//    INSERT INTO developers_skills(developer_id, skill_id, language_id) VALUES (5, 1, 1);
//    INSERT INTO customers(name, age) VALUES ('Jay Custody', 45);
//    INSERT INTO customers_projects(project_id, customer_id) VALUES (16, 11);

}
