package com.epam.jwd.repo.comparator;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.geometry.ConeGeometry;
import com.epam.jwd.geometry.impl.ConeGeometryImpl;

import java.util.Comparator;

public class VolumeConeComparator implements Comparator<Cone> {

    private final static ConeGeometry geometry = ConeGeometryImpl.getInstance();

    @Override
    public int compare(Cone o1, Cone o2) {
        return (int) (geometry.volume(o1) - geometry.volume(o2));
    }
}
