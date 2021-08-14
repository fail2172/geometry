package com.epam.jwd.registrar.impl;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.registrar.ConeSubscriber;

public class ConeSubscriberImpl implements ConeSubscriber {

    private static ConeSubscriberImpl instance;

    private final static ConeGeometry geometry = ConeGeometry.getInstance();
    private Double height;
    private Double radius;
    private Double volume;
    private Double surfaceArea;

    ConeSubscriberImpl(Cone cone) {
        height = cone.getHeight();
        radius = cone.getRadius();
        volume = geometry.volume(cone);
        surfaceArea = geometry.surfaceArea(cone);
    }

    ConeSubscriberImpl() {

    }

    public static ConeSubscriberImpl getInstance(Cone cone) {
        if (instance == null) {
            instance = new ConeSubscriberImpl(cone);
        }
        return instance;
    }

    public static ConeSubscriberImpl getInstance() {
        if (instance == null) {
            instance = new ConeSubscriberImpl();
        }
        return instance;
    }

    @Override
    public void update(Cone cone) {
        height = cone.getHeight();
        radius = cone.getRadius();
        volume = geometry.volume(cone);
        surfaceArea = geometry.surfaceArea(cone);
    }

    public Double getHeight() {
        return height;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getVolume() {
        return volume;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConeSubscriberImpl that = (ConeSubscriberImpl) o;

        if (!height.equals(that.height)) return false;
        if (!radius.equals(that.radius)) return false;
        if (!volume.equals(that.volume)) return false;
        return surfaceArea.equals(that.surfaceArea);
    }

    @Override
    public int hashCode() {
        int result = height.hashCode();
        result = 31 * result + radius.hashCode();
        result = 29 * result + volume.hashCode();
        result = 99 * result + surfaceArea.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ConeSubscriberImpl{" +
                "height=" + height +
                ", radius=" + radius +
                ", volume=" + volume +
                ", surfaceArea=" + surfaceArea +
                '}';
    }
}
