package com.epam.jwd.repo;

import com.epam.jwd.entity.impl.GeometricContext;
import com.epam.jwd.exception.GeometricObjectNotFoundException;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    T update(int id, GeometricContext newContext) throws GeometricObjectNotFoundException;
    T read(int id) throws GeometricObjectNotFoundException;
    int size();
    void save(T object);
    void remove(int id) throws GeometricObjectNotFoundException;
    void sort(Comparator<T> comparator);
    void sort();

    List<T> query(Specification<T> specification) throws FileNotFoundException;
}
