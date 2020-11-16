package com.dermentli.projectmanagementsystem.dao;

public enum Gender {
    MALE,
    FEMALE,
    NOT_MENTIONED;

    public static Gender ofName(String gender) {
        switch (gender) {
            case("male"):
                return Gender.MALE;
            case("female"):
                return Gender.FEMALE;
            case("not mentioned"):
                return Gender.NOT_MENTIONED;
        }
        return null;
    }
}
