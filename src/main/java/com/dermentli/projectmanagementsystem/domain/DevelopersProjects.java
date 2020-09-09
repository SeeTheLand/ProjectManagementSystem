package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DevelopersProjects {
    private Long project_id;
    private Long developers_id;

}