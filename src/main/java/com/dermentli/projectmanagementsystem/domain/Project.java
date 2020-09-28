package com.dermentli.projectmanagementsystem.domain;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {
    private Long id;
    private String name;
    private Integer latestReleaseDate;
    private Integer cost;
    private Integer count;

    public Project(Long id, String name, int latestReleaseDate, int cost) {
        this.id = id;
        this.name = name;
        this.latestReleaseDate = latestReleaseDate;
        this.cost = cost;
    }
}
