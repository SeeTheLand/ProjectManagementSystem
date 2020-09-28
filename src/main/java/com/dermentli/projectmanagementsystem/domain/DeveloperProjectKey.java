package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeveloperProjectKey {
    private Long developerID;
    private Long projectID;

}
