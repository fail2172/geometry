package com.epam.jwd.repo;

import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    T update(int id, GeometricContext newContext) throws NotFoundGeometricObjectException;
    T read(int id) throws NotFoundGeometricObjectException;
    int size();
    void save(T object);
    void remove(int id) throws NotFoundGeometricObjectException;
    void sort(Comparator<T> comparator);
    void sort();

    List<T> query(Specification<T> specification);
}
