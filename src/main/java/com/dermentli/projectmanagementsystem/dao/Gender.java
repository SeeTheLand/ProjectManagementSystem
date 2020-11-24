package com.dermentli.projectmanagementsystem.dao;

public enum Gender {
    male,
    female,
    not_mentioned;

    public static Gender ofName(String gender) {
        switch (gender) {
            case("male"):
                return Gender.male;
            case("female"):
                return Gender.female;
            case("not_mentioned"):
                return Gender.not_mentioned;
        }
        return null;
    }
}
