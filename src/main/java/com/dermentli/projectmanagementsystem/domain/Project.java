package com.dermentli.projectmanagementsystem.domain;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
//@ToString(exclude = "count")
public class Project {
    private Long id;
    private String name;
    private Integer latestReleaseDate;
    private Integer cost;
    private Integer count;

    public Project(Long id, String name, int latest_release_date, int cost) {
        this.id = id;
        this.name = name;
        this.latestReleaseDate = latest_release_date;
        this.cost = cost;
    }
}
