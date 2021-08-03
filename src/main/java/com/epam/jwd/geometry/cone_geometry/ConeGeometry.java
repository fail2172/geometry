package com.epam.jwd.geometry.cone_geometry;

import com.epam.jwd.geometric_object.CoordinatePlane;
import com.epam.jwd.geometric_object.Cone;

public interface ConeGeometry {
    double surfaceArea(Cone cone);
    double volume(Cone cone);
    double volumeRatio(Cone cone, CoordinatePlane plane);
    double longitudinalSectionArea(Cone cone, CoordinatePlane plane);
    boolean isCone(Object object);
    boolean baseOnTheCoordinatePlane(Cone cone);

    static ConeGeometry instance() {
        return new ConeGeometryImpl();
    }
}
