package com.epam.jwd.geometry.cone_geometry;

import com.epam.jwd.exception.NoPlaneIntersection;
import com.epam.jwd.geometric_object.Cone;
import com.epam.jwd.geometry.Geometry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class ConeGeometryImpl implements ConeGeometry {
    private final static Logger LOG = LogManager.getLogger(ConeGeometryImpl.class);
    public static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    public static final String CONE_GEOMETRY_PROPERTIES = "src/main/resources/cone_geometry.properties";
    private Properties properties = null;

    ConeGeometryImpl() {
        try {
            properties = new Properties();
            FileInputStream stream = new FileInputStream(CONE_GEOMETRY_PROPERTIES);
            properties.load(stream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public double surfaceArea(Cone cone) {
        double result = Geometry.sectorArea(
                Geometry.hypotenuse(cone.getHeight(), cone.getBase().getRadius()),
                Geometry.circumference(cone.getBase().getRadius())) + Geometry.circleArea(cone.getBase().getRadius());

        LOG.trace(properties.getProperty("SURFACE_AREA"));

        return result;
    }

    @Override
    public double volume(Cone cone) {
        double result = Geometry.circleArea(cone.getBase().getRadius()) * cone.getHeight() / 3;

        LOG.trace(properties.getProperty("VOLUME"));

        return result;
    }

    @Override
    public double volumeRatio(Cone cone) {
        try {
            planeIntersection(cone);

            double result = Math.pow(cone.getBase().getCenter().getZ() + cone.getHeight(), 3)
                    / (Math.pow(cone.getHeight(), 3) - Math.pow(cone.getBase().getCenter().getZ() + cone.getHeight(), 3));

            LOG.trace(properties.getProperty("VOLUME_RATIO"));

            return result;
        } catch (NoPlaneIntersection e) {
            LOG.error(e.getMessage());
            return 0;
        }
    }

    private void planeIntersection(Cone cone) throws NoPlaneIntersection {
        if (cone.getBase().getCenter().getZ()>=0) {
            Properties properties = new Properties();
            try {
                FileInputStream stream = new FileInputStream(EXCEPTIONS_PROPERTIES);
                properties.load(stream);
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
            throw new NoPlaneIntersection(properties.getProperty("NO_PLANE_INTERSECTION"));
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
