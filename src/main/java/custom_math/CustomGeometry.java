package custom_math;

public interface CustomGeometry {
    double P = 3.14;

    default double circleArea(double radius) {
        return P * Math.pow(radius, 2);
    }

    default double circumference(double radius) {
        return 2 * P * radius;
    }

    default double hypotenuse(double leg1, double leg2) {
        return Math.pow(Math.pow(leg1, 2) + Math.pow(leg2, 2), 0.5);
    }

    default double sectorArea(double radius, double arcLength){
        return circleArea(radius) * arcLength / circumference(radius);
    }
}
