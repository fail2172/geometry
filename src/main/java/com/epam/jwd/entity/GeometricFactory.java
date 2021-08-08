package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricObjectContext;

public interface GeometricFactory {
    GeometricObject createObject(GeometricObjectContext context);

    static GeometricFactory instance(){
        return new GeometricObjectFactory();
    }
}
