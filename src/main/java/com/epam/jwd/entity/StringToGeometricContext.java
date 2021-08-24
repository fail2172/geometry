package com.epam.jwd.entity;

import com.epam.jwd.entity.impl.GeometricContext;
import com.epam.jwd.exception.GeometricObjectTypeNotFoundException;
import com.epam.jwd.exception.IncorrectInputException;

public interface StringToGeometricContext {
    GeometricContext getContextFromString(String strContext) throws GeometricObjectTypeNotFoundException,
            IncorrectInputException;
}
