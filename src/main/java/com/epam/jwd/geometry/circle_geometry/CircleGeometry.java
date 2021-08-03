package com.epam.jwd.geometry.circle_geometry;

import com.epam.jwd.geometric_object.Circle;
import com.epam.jwd.geometric_object.CoordinatePlane;

public interface CircleGeometry {
    public double lengthOfTheSectionByTheCoordinatePlane(Circle circle, CoordinatePlane plane);

    static CircleGeometry instance(){
        return new CircleGeometryImpl();
    }
}
