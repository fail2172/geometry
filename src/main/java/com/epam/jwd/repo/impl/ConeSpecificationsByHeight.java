package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.Cone;
import com.epam.jwd.repo.ConeSpecification;

public class ConeSpecificationsByHeight implements ConeSpecification {

    private final double from;
    private final double to;

    public ConeSpecificationsByHeight(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        return from <= cone.getHeight() && cone.getHeight() <= to;
    }
}
