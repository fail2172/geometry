package com.epam.jwd.entity;

import com.epam.jwd.entity.impl.GeometricContext;
import com.epam.jwd.exception.GeometricObjectTypeNotFoundException;

public interface GeometricFactory {
    GeometricObject createObject(GeometricContext context) throws GeometricObjectTypeNotFoundException;
}
