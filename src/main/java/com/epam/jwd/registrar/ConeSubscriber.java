package com.epam.jwd.registrar;

import com.epam.jwd.entity.impl.Cone;
import com.epam.jwd.registrar.impl.ConeSubscriberImpl;

public interface ConeSubscriber {

    void update(Cone cone);
}
