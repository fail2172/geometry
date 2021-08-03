package geometry.cone_geometry;

import geometric_object.CoordinatePlane;
import geometric_object.Cone;

public interface ConeGeometry {
    double surfaceArea(Cone cone);
    double volume(Cone cone);
    double volumeRatio(Cone cone, CoordinatePlane plane);
    double longitudinalSectionArea(Cone cone, CoordinatePlane plane);
    boolean isCone(Object object);

    static ConeGeometry instance() {
        return new ConeGeometryImpl();
    }
}
