package com.dermentli.projectmanagementsystemhibernate.domain;

import com.dermentli.projectmanagementsystemhibernate.dao.Gender;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "developers")
public class Developer {
    @Id
    private Long id;

    private String name;

    private int age;

    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
                joinColumns = @JoinColumn(name = "developer_id"),
                inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;
}
