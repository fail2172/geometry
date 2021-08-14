package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.GeometricObject;

public class Circle implements GeometricObject {

    private final CustomPoint center;
    private Double radius;

    Circle(double x, double y, double z, Double radius) {
        this.center = new CustomPoint(x, y, z);
        this.radius = radius;
    }

    public CustomPoint getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(Double x, Double y, Double z) {
        center.setX(x);
        center.setY(y);
        center.setZ(z);
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (!center.equals(circle.center)) return false;
        return radius.equals(circle.radius);
    }

    @Override
    public int hashCode() {
        int result = center.hashCode();
        result = 31 * result + radius.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
