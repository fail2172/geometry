package com.epam.jwd.geometry;

import com.epam.jwd.entity.impl.Cone;

import java.io.FileNotFoundException;

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
}
