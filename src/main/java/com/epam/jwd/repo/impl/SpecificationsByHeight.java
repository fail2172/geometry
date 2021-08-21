package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.repo.Specification;

public class SpecificationsByHeight implements Specification<Cone> {

    private final double from;
    private final double to;

    public SpecificationsByHeight(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        return from <= cone.getHeight() && cone.getHeight() <= to;
    }
}
