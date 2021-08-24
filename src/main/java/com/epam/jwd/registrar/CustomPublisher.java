package com.epam.jwd.registrar;

public interface CustomPublisher {
    void subscribe(ConeSubscriber coneSubscriber);
    void unsubscribe(ConeSubscriber coneSubscriber);
    void notifySubscribers();
}
