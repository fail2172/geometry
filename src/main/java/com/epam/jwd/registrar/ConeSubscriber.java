package com.epam.jwd.registrar;

import com.epam.jwd.entity.Cone;

public interface ConeSubscriber {

    void update(Cone cone);

    static ConeSubscriber getInstance(Cone cone){
        return ConeSubscriberImpl.getInstance(cone);
    }
    static ConeSubscriber getInstance(){
        return ConeSubscriberImpl.getInstance();
    }
}
