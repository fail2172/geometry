package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.repo.ConeSpecification;

public class ConeSpecificationsBySurfaceArea implements ConeSpecification {
    private final static ConeGeometry geometry = ConeGeometry.getInstance();
    private final double from;
    private final double to;

    public ConeSpecificationsBySurfaceArea(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        double result = geometry.surfaceArea(cone);
        return from <= result && result <= to;
    }
}
