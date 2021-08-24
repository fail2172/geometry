package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.repo.Specification;

public class SpecificationsByRadius implements Specification<Cone> {

    private final double from;
    private final double to;

    public SpecificationsByRadius(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        return from <= cone.getRadius() && cone.getRadius() <= to;
    }
}
