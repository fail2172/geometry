package com.epam.jwd.geometry.cone;

import com.epam.jwd.entity.Cone;

public interface ConeGeometry {
    double surfaceArea(Cone cone);
    double volume(Cone cone);
    double volumeRatio(Cone cone);
    boolean isCone(Object object);
    boolean baseOnTheCoordinatePlane(Cone cone);

    static ConeGeometry instance() {
        return new ConeGeometryImpl();
    }
}
