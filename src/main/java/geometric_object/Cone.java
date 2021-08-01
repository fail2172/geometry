package geometric_object;

import geometric_object.object_context.GeometricObjectContext;

import java.util.Objects;

public class Cone implements GeometricObject {
    private final Circle base;
    private final double height;

    Cone(double x, double y, double z, double height, double radiusOfBase) {
        GeometricObjectContext context = GeometricObjectContext.of(
                GeometricObjectType.CIRCLE, x, y, z).setRadius(radiusOfBase).build();
        this.base = (Circle) GeometricObject.of(context);
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
        return Double.compare(cone.height, height) == 0 && Objects.equals(base, cone.base);
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
