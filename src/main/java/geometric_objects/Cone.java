package geometric_objects;

public class Cone {
    private final double xCoordinateCenterOfBase;
    private final double yCoordinateCenterOfBase;
    private final double zCoordinateCenterOfBase;
    private final double height;
    private final double radiusOfBase;

    public Cone(double xCoordinateCenterOfBase, double yCoordinateCenterOfBase,
                double zCoordinateCenterOfBase, double height, double radiusOfBase) {
        this.xCoordinateCenterOfBase = xCoordinateCenterOfBase;
        this.yCoordinateCenterOfBase = yCoordinateCenterOfBase;
        this.zCoordinateCenterOfBase = zCoordinateCenterOfBase;
        this.height = height;
        this.radiusOfBase = radiusOfBase;
    }

    public double getXCoordinateCenterOfBase() {
        return xCoordinateCenterOfBase;
    }

    public double getYCoordinateCenterOfBase() {
        return yCoordinateCenterOfBase;
    }

    public double getZCoordinateCenterOfBase() {
        return zCoordinateCenterOfBase;
    }

    public double getHeight() {
        return height;
    }

    public double getRadiusOfBase() {
        return radiusOfBase;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
