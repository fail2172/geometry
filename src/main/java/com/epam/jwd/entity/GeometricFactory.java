package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;

public interface GeometricFactory {
    GeometricObject createObject(GeometricContext context) throws NotFoundGeometricObjectException;

    static GeometricFactory instance(){
        return GeometricObjectFactory.getInstance();
    }
}
