package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DevelopersProjects {
    private Long project_id;
    private Long developer_id;


    public DeveloperProjectKey getDeveloperProjectID() {
        return new DeveloperProjectKey(this.project_id, this.developer_id);
    }
}