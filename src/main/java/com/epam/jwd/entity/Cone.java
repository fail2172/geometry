package com.epam.jwd.entity;

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
