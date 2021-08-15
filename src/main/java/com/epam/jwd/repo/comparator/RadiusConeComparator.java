package com.epam.jwd.repo.comparator;

import com.epam.jwd.entity.impl.Cone;

import java.util.Comparator;

public class RadiusConeComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        return (int) (o1.getRadius() - o2.getRadius());
    }
}
