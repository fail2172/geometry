package geometric_object;

import geometric_object.object_context.GeometricObjectContext;

import java.util.Objects;

public class Circle implements GeometricObject {
    private final Point center;
    private final Double radius;

    Circle(double x, double y, double z, Double radius) {
        GeometricFactory factory = GeometricFactory.instance();
        GeometricObjectContext context = GeometricObjectContext.of(GeometricObjectType.POINT, x, y, z).build();
        this.center = (Point) factory.createObject(context);
        this.radius = radius;
    }

    public Point getCenter() {
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
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
