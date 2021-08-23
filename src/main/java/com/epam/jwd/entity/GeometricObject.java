package com.epam.jwd.entity;

import com.epam.jwd.entity.impl.GeometricContext;

public interface GeometricObject extends Comparable<GeometricObject>{
    void setContext(GeometricContext context);
}
