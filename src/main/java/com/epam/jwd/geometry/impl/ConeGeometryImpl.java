package com.epam.jwd.geometry.impl;

import com.epam.jwd.exception.NoPlaneIntersection;
import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.reader.MessageReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeGeometryImpl implements ConeGeometry {
    private final static Logger LOG = LogManager.getLogger(ConeGeometryImpl.class);
    private static final MessageReader messageReader = MessageReader.getInstance();
    private static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private static final String CONE_GEOMETRY_PROPERTIES = "src/main/resources/cone_geometry.properties";
    private static ConeGeometryImpl instance;

    ConeGeometryImpl() {
    }

    public static ConeGeometryImpl getInstance() {
        if (instance == null) {
            instance = new ConeGeometryImpl();
        }
        return instance;
    }

    @Override
    public double surfaceArea(Cone cone) {

        LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "SURFACE_AREA"));

        return sectorArea(
                hypotenuse(cone.getHeight(), cone.getRadius()),
                circumference(cone.getRadius())) + circleArea(cone.getRadius());
    }

    @Override
    public double volume(Cone cone) {

        LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "VOLUME"));

        return circleArea(cone.getRadius()) * cone.getHeight() / 3;
    }

    @Override
    public double volumeRatio(Cone cone) {
        try {
            planeIntersection(cone);

            LOG.trace(messageReader.getMessage(CONE_GEOMETRY_PROPERTIES, "VOLUME_RATIO"));

            return Math.pow(cone.getZOfCenterBase() + cone.getHeight(), 3)
                    / (Math.pow(cone.getHeight(), 3) - Math.pow(cone.getZOfCenterBase() + cone.getHeight(), 3));
        } catch (NoPlaneIntersection e) {
            LOG.error(e);
            return 0;
        }
    }

    @Override
    public double distanceFromTheCenterOfCoordinates(Cone cone) {
        return distanceBetweenPoints(0, 0, 0,
                cone.getXOfCenterBase(), cone.getYOfCenterBase(), cone.getZOfCenterBase());
    }

    private void planeIntersection(Cone cone) throws NoPlaneIntersection {
        if (cone.getZOfCenterBase() >= 0) {
            throw new NoPlaneIntersection(messageReader.getMessage(EXCEPTIONS_PROPERTIES, "NO_PLANE_INTERSECTION"));
        }
    }

    @Override
    public boolean isCone(Object object) {
        return object instanceof Cone;
    }

    @Override
    public boolean baseOnTheCoordinatePlane(Cone cone) {
        return cone.getZOfCenterBase() == 0;
    }
}
