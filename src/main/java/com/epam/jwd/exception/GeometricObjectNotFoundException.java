package com.epam.jwd.exception;

public class GeometricObjectNotFoundException extends ClassNotFoundException {
    public GeometricObjectNotFoundException(String message){
        super(message);
    }

    public GeometricObjectNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
