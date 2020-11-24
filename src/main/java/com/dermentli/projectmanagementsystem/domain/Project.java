package com.dermentli.projectmanagementsystem.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {
    private Long id;
    private String name;
    private Integer latestReleaseDate;
    private BigDecimal cost;

    public Project(Long id, String name, int latestReleaseDate, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.latestReleaseDate = latestReleaseDate;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.latestReleaseDate + " - " + this.cost;
    }
}
