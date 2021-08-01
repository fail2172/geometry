package geometry.circle_geometry;

import geometric_object.Circle;
import geometric_object.CoordinatePlane;

import java.io.IOException;

public interface CircleGeometry {
    public double lengthOfTheSectionByTheCoordinatePlane(Circle circle, CoordinatePlane plane);

    static CircleGeometry instance(){
        return new CircleGeometryImpl();
    }
}
