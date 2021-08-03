package com.epam.jwd.geometry;

public final class Geometry {
    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static double circumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double hypotenuse(double leg1, double leg2) {
        return Math.pow(Math.pow(leg1, 2) + Math.pow(leg2, 2), 0.5);
    }

    public static double leg(double hypotenuse, double otherLeg){
        return Math.pow(Math.pow(hypotenuse, 2) - Math.pow(otherLeg, 2), 0.5);
    }

    public static double sectorArea(double radius, double arcLength){
        return circleArea(radius) * arcLength / circumference(radius);
    }
}
