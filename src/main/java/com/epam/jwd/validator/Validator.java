package com.epam.jwd.validator;

import com.epam.jwd.entity.impl.GeometricObjectType;

public interface Validator {
    boolean checkContext(GeometricObjectType contextType, String stringContext);
}
