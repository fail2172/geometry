package com.epam.jwd.entity;

public class Circle implements GeometricObject {

    private final CustomPoint center;
    private final Double radius;

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
