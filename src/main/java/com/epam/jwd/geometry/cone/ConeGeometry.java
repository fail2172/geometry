package com.epam.jwd.geometry.cone;

import com.epam.jwd.entity.Cone;
import com.epam.jwd.geometry.Geometry;

public interface ConeGeometry extends Geometry {
    double surfaceArea(Cone cone);
    double volume(Cone cone);
    double volumeRatio(Cone cone);
    /**
     * Данный метод возвращаяет расстояние от центра основания конуса до центра координат
     */
    double distanceFromTheCenterOfCoordinates(Cone cone);
    boolean isCone(Object object);
    boolean baseOnTheCoordinatePlane(Cone cone);

    static ConeGeometry instance() {
        return new ConeGeometryImpl();
    }
}
