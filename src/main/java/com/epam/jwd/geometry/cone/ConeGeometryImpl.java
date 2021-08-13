package com.epam.jwd.geometry.cone;

import com.epam.jwd.exception.NoPlaneIntersection;
import com.epam.jwd.entity.Cone;
import com.epam.jwd.geometry.Geometry;
import com.epam.jwd.reader.MessageReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConeGeometryImpl implements ConeGeometry {
    private final static Logger LOG = LogManager.getLogger(ConeGeometryImpl.class);
    private static final MessageReader messageReader = MessageReader.instance();
    private static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private static final String CONE_GEOMETRY_PROPERTIES = "src/main/resources/cone_geometry.properties";

    ConeGeometryImpl() {

    }

    @Override
    public double surfaceArea(Cone cone) {
        double result = Geometry.sectorArea(
                Geometry.hypotenuse(cone.getHeight(), cone.getBase().getRadius()),
                Geometry.circumference(cone.getBase().getRadius())) + Geometry.circleArea(cone.getBase().getRadius());

        LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "SURFACE_AREA"));

        return result;
    }

    @Override
    public double volume(Cone cone) {
        double result = Geometry.circleArea(cone.getBase().getRadius()) * cone.getHeight() / 3;

        LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "VOLUME"));

        return result;
    }

    @Override
    public double volumeRatio(Cone cone) {
        try {
            planeIntersection(cone);

            double result = Math.pow(cone.getBase().getCenter().getZ() + cone.getHeight(), 3)
                    / (Math.pow(cone.getHeight(), 3) - Math.pow(cone.getBase().getCenter().getZ() + cone.getHeight(), 3));

            LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "VOLUME_RATIO"));

            return result;
        } catch (NoPlaneIntersection e) {
            LOG.error(e.getMessage());
            return 0;
        }
    }

    private void planeIntersection(Cone cone) throws NoPlaneIntersection {
        if (cone.getBase().getCenter().getZ() >= 0) {
            throw new NoPlaneIntersection(messageReader.getMessage(EXCEPTIONS_PROPERTIES, "NO_PLANE_INTERSECTION"));
        }
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
