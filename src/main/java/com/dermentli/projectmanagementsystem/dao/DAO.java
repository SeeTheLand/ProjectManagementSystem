package com.dermentli.projectmanagementsystem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    void add(T element) throws SQLException;

    void remove(T element);

    void removeById(long id);

    Optional<T> findById(long id);

    List<T> findAll();

    void removeAll();

    void addAll(List<T> elements) throws SQLException;
}
