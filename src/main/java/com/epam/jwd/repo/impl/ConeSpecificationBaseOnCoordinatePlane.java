package com.epam.jwd.repo.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.repo.ConeSpecification;

public class ConeSpecificationBaseOnCoordinatePlane implements ConeSpecification{

    private final static ConeGeometry geometry = ConeGeometry.getInstance();

    @Override
    public boolean specified(Cone cone) {
        return geometry.baseOnTheCoordinatePlane(cone);
    }
}
