package com.epam.jwd.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Cone implements GeometricObject {
    private final static Logger LOG = LogManager.getLogger(Cone.class);
    private static final String CREATING_A_CONE = "creating a cone";
    private final Circle base;
    private final Double height;

    Cone(double x, double y, double z, Double height, Double radiusOfBase) {
        LOG.trace(CREATING_A_CONE);
        this.base = new Circle(x, y, z, radiusOfBase);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public Circle getBase() {
        return base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cone cone = (Cone) o;

        if (!base.equals(cone.base)) return false;
        return height.equals(cone.height);
    }

    @Override
    public int hashCode() {
        int result = base.hashCode();
        result = 31 * result + height.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
}
