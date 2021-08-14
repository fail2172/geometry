package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.Cone;
import com.epam.jwd.repo.ConeSpecification;

public class ConeSpecificationsByRadius implements ConeSpecification {

    private final double from;
    private final double to;

    public ConeSpecificationsByRadius(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        return from <= cone.getRadius() && cone.getRadius() <= to;
    }
}
