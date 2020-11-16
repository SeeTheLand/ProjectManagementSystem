package com.dermentli.projectmanagementsystem.domain;

import com.dermentli.projectmanagementsystem.dao.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Developer {
    private Long id;
    private String name;
    private int age;
    private BigDecimal salary;
    private Gender gender;

}
