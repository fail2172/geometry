package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.GeometricObject;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;
import com.epam.jwd.registrar.CustomPublisher;
import com.epam.jwd.registrar.ConeSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Cone implements GeometricObject, CustomPublisher {

    private final Circle base;
    private Double height;
    private final List<ConeSubscriber> coneSubscribers;

    Cone(double x, double y, double z, Double height, Double radiusOfBase) {
        this.base = new Circle(x, y, z, radiusOfBase);
        this.height = height;
        coneSubscribers = new ArrayList<>();
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return base.getRadius();
    }

    public double getXOfCenterBase() {
        return base.getCenter().getX();
    }

    public double getYOfCenterBase() {
        return base.getCenter().getY();
    }

    public double getZOfCenterBase() {
        return base.getCenter().getZ();
    }

    public void setRadius(Double radius) {
        base.setRadius(radius);
        notifySubscribers();
    }

    public void setHeight(Double height) {
        this.height = height;
        notifySubscribers();
    }

    public void setCenter(Double x, Double y, Double z) {
        base.setCenter(x, y, z);
    }


    @Override
    public void setContext(GeometricContext context) {
        this.setHeight(context.getHeight());
        this.setRadius(context.getRadius());
        this.setCenter(context.getX(), context.getY(), context.getZ());
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

    @Override
    public void subscribe(ConeSubscriber coneSubscriber) {
        coneSubscribers.add(coneSubscriber);
    }

    @Override
    public void unsubscribe(ConeSubscriber coneSubscriber) {
        coneSubscribers.remove(coneSubscriber);
    }

    @Override
    public void notifySubscribers() {
        for (ConeSubscriber coneSubscriber : coneSubscribers
        ) {
            coneSubscriber.update(this);
        }
    }

    @Override
    public int compareTo(GeometricObject o) {
        ConeGeometry geometry = ConeGeometryImpl.getInstance();
        return (int) (geometry.volume(this) - geometry.volume((Cone) o));
    }
}
