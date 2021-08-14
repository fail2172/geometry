package com.epam.jwd.repo;

import com.epam.jwd.entity.Cone;

public interface ConeSpecification {
    boolean specified(Cone cone);
}
