package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;
import com.epam.jwd.repo.Specification;

public class SpecificationByDistance implements Specification<Cone> {
    private final static ConeGeometry geometry = ConeGeometryImpl.getInstance();
    private final double from;
    private final double to;

    public SpecificationByDistance(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        double result = geometry.distanceFromTheCenterOfCoordinates(cone);
        return from <= result && result <= to;
    }
}