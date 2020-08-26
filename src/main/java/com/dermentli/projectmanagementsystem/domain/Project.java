package com.dermentli.projectmanagementsystem.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "sumSalary")
public class Project {
    private Integer sumSalary;
    private Integer latestReleaseDate;
    private String name;
    private Integer numberOfDevelopers;

}
