package com.dermentli.projectmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {

    void add(T element);

    void remove(T element);

    void removeById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void removeAll();

    void addAll(List<T> elements);
}
