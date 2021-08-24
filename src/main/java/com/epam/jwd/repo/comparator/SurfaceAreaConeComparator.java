package com.epam.jwd.repo.comparator;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;

import java.util.Comparator;

public class SurfaceAreaConeComparator implements Comparator<Cone> {

    private final static ConeGeometry geometry = ConeGeometryImpl.getInstance();

    @Override
    public int compare(Cone o1, Cone o2) {
        return (int) (geometry.surfaceArea(o1) - geometry.surfaceArea(o2));
    }
}
