package com.epam.jwd.repo.comparator;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;

import java.util.Comparator;

public class DistanceConeComparator implements Comparator<Cone> {

    ConeGeometry geometry = ConeGeometryImpl.getInstance();

    @Override
    public int compare(Cone o1, Cone o2) {
        return (int) (geometry.distanceFromTheCenterOfCoordinates(o1) - geometry.distanceFromTheCenterOfCoordinates(o2));
    }
}
