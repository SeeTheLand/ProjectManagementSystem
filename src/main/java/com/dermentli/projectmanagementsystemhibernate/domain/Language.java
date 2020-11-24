package com.dermentli.projectmanagementsystemhibernate.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "languages")
public class Language {

    public enum LanguageEnum {
        Java,
        CPlusPlus,
        CSharp,
        JavaScript
    }

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private LanguageEnum name;
}
