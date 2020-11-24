package com.dermentli.projectmanagementsystemhibernate.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    private Long id;

    private String name;

    @Column(name = "latest_release_date")
    private Integer latestReleaseDate;

    private BigDecimal cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_projects",
                joinColumns = @JoinColumn(name = "project_id"),
                inverseJoinColumns = @JoinColumn(name = "developer_id"))
    private List<Developer> developers;

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.latestReleaseDate + " - " + this.cost;
    }

}
