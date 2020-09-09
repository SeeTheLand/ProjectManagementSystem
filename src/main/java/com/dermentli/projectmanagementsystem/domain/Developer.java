package com.dermentli.projectmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Developer {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private int salary;

}
