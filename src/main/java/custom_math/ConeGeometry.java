package custom_math;

import geometric_objects.Cone;

public interface ConeGeometry extends CustomGeometry{
    double surfaceArea(Cone cone);
    double volume(Cone cone);
}
