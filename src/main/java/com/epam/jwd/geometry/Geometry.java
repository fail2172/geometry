package com.epam.jwd.geometry;

public interface Geometry {
    default double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    default double circumference(double radius) {
        return 2 * Math.PI * radius;
    }

    default double hypotenuse(double leg1, double leg2) {
        return Math.pow(Math.pow(leg1, 2) + Math.pow(leg2, 2), 0.5);
    }

    default double sectorArea(double radius, double arcLength){
        return circleArea(radius) * arcLength / circumference(radius);
    }
}
