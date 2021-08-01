package geometric_object.object_context;

import geometric_object.GeometricObjectType;

import java.util.Objects;

public class GeometricObjectContext {
    private final GeometricObjectType type;

    private final double x;
    private final double y;
    private final double z;

    private Double height;
    private Double radius;

    private GeometricObjectContext(GeometricObjectType type, double x, double y, double z) {
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
        GeometricObjectContext context = (GeometricObjectContext) o;
        return x == context.x && y == context.y && z == context.z
                && Objects.equals(height, context.height)
                && Objects.equals(radius, context.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, height, radius);
    }

    public static Builder of(GeometricObjectType type, double x, double y, double z) {
        return new GeometricObjectContext(type, x, y, z).new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setHeight(Double height) {
            GeometricObjectContext.this.height = height;
            return this;
        }

        public Builder setRadius(Double radius) {
            GeometricObjectContext.this.radius = radius;
            return this;
        }

        public GeometricObjectContext build() {
            return GeometricObjectContext.this;
        }
    }
}
