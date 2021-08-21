package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;
import com.epam.jwd.repo.Specification;

public class SpecificationBaseOnCoordinatePlane implements Specification<Cone> {

    private final static ConeGeometry geometry = ConeGeometryImpl.getInstance();

    @Override
    public boolean specified(Cone cone) {
        return geometry.baseOnTheCoordinatePlane(cone);
    }
}