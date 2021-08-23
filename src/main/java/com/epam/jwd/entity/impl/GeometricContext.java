package com.epam.jwd.entity.impl;

public class GeometricContext {

    private final GeometricObjectType type;

    private final double x;
    private final double y;
    private final double z;

    private Double height;
    private Double radius;

    private GeometricContext(GeometricObjectType type, double x, double y, double z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public GeometricObjectType getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Double getHeight() {
        return height;
    }

    public Double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "GeometryObjectContext{" +
                "type=" + type +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", height=" + height +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeometricContext that = (GeometricContext) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.z, z) != 0) return false;
        if (type != that.type) return false;
        if (!height.equals(that.height)) return false;
        return radius.equals(that.radius);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        temp = Double.doubleToLongBits(x);
        result = 17 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 71 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 33 * result + (int) (temp ^ (temp >>> 32));
        result = 11 * result + height.hashCode();
        result = 19 * result + radius.hashCode();
        return result;
    }

    public static Builder of(GeometricObjectType type, double x, double y, double z) {
        return new GeometricContext(type, x, y, z).new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setHeight(Double height) {
            GeometricContext.this.height = height;
            return this;
        }

        public Builder setRadius(Double radius) {
            GeometricContext.this.radius = radius;
            return this;
        }

        public GeometricContext build() {
            return GeometricContext.this;
        }
    }
}
