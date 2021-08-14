package com.epam.jwd.repo;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;

import java.util.List;

public interface ConeRepository {
    void save(Cone cone);
    void remove(int id) throws NotFoundGeometricObjectException;
    Cone update(int id, GeometricContext newContext) throws NotFoundGeometricObjectException;
    Cone read(int id) throws NotFoundGeometricObjectException;

    List<Cone> query(ConeSpecification specification);
}
