package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Project {
    private Long id;
    private String name;
    private Integer latestReleaseDate;
    private Integer cost;

}
