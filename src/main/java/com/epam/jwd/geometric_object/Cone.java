package com.epam.jwd.geometric_object;

import java.util.Objects;

public class Cone implements GeometricObject {
    private final Circle base;
    private final Double height;

    Cone(double x, double y, double z, Double height, Double radiusOfBase) {
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
        return base.equals(cone.base) && height.equals(cone.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }

    @Override
    public String toString() {
        return "Cone{" +
                "base=" + base +
                ", height=" + height +
                '}';
    }
}
