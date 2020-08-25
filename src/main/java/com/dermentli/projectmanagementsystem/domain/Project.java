package com.dermentli.projectmanagementsystem.domain;

import lombok.Data;

@Data
public class Project {
    private Integer sumSalary;
    private Integer latestReleaseDate;
    private String name;
    private Integer numberOfDevelopers;

}
