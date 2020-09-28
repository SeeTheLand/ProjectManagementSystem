package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DevelopersProjects {
    private Long projectID;
    private Long developerID;


    public DeveloperProjectKey getDeveloperProjectID() {
        return new DeveloperProjectKey(this.projectID, this.developerID);
    }
}