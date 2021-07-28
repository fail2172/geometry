package custom_math.impl;

import custom_math.ConeGeometry;
import geometric_objects.Cone;

public class ConeGeometryImpl implements ConeGeometry {

    @Override
    public double surfaceArea(Cone cone) {
        return sectorArea(hypotenuse(cone.getHeight(), cone.getRadiusOfBase()), circumference(cone.getRadiusOfBase()));
    }

    @Override
    public double volume(Cone cone) {
        return circleArea(cone.getRadiusOfBase()) * cone.getHeight() / 3;
    }
}
