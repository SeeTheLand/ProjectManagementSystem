package com.dermentli.projectmanagementsystem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

    void add(T element) throws SQLException;

    void remove(T element);

    void removeById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void removeAll();

    void addAll(List<T> elements) throws SQLException;
}
