package com.epam.jwd.geometry.cone_geometry;

import com.epam.jwd.geometric_object.Cone;
import com.epam.jwd.geometry.Geometry;

class ConeGeometryImpl implements ConeGeometry {

    ConeGeometryImpl() {
    }

    @Override
    public double surfaceArea(Cone cone) {
        return Geometry.sectorArea(
                Geometry.hypotenuse(cone.getHeight(), cone.getBase().getRadius()),
                Geometry.circumference(cone.getBase().getRadius())) + Geometry.circleArea(cone.getBase().getRadius()
        );
    }

    @Override
    public double volume(Cone cone) {
        return Geometry.circleArea(cone.getBase().getRadius()) * cone.getHeight() / 3;
    }

    @Override
    public double volumeRatio(Cone cone) {
        return Math.pow(cone.getBase().getCenter().getY() + cone.getHeight(), 2)
                / (Math.pow(cone.getHeight(), 2) - Math.pow(cone.getBase().getCenter().getY() + cone.getHeight(), 2));
    }

    @Override
    public boolean isCone(Object object) {
        return object instanceof Cone;
    }

    @Override
    public boolean baseOnTheCoordinatePlane(Cone cone) {
        return cone.getBase().getCenter().getZ() == 0;
    }
}
