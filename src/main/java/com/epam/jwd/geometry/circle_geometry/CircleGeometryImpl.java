package com.epam.jwd.geometry.circle_geometry;

import com.epam.jwd.geometric_object.Circle;
import com.epam.jwd.geometric_object.CoordinatePlane;
import com.epam.jwd.geometry.Geometry;

public class CircleGeometryImpl implements CircleGeometry {
    @Override
    public double lengthOfTheSectionByTheCoordinatePlane(Circle circle, CoordinatePlane plane) {
        return switch (plane) {
            case XZ -> 2 * Geometry.leg(circle.getRadius(), circle.getCenter().getY());
            case YZ -> 2 * Geometry.leg(circle.getRadius(), circle.getCenter().getX());
            default -> 0;
        };
    }
}
