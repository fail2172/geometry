package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.Cone;
import com.epam.jwd.geometry.cone.ConeGeometry;
import com.epam.jwd.repo.ConeSpecification;

public class ConeSpecificationsByVolume implements ConeSpecification {

    private final static ConeGeometry geometry = ConeGeometry.instance();
    private final double from;
    private final double to;

    public ConeSpecificationsByVolume(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specified(Cone cone) {
        double result = geometry.volume(cone);
        return from <= result && result <= to;
    }
}
