package geometry.circle_geometry;

import geometric_object.Circle;
import geometric_object.CoordinatePlane;

public interface CircleGeometry {
    public double chord(Circle circle, CoordinatePlane plane);

    static CircleGeometry instance(){
        return new CircleGeometryImpl();
    }
}
