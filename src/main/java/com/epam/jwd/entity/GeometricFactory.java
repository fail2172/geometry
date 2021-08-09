package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricContext;

public interface GeometricFactory {
    GeometricObject createObject(GeometricContext context);

    static GeometricFactory instance(){
        return new GeometricObjectFactory();
    }
}
