package com.epam.jwd.exception;

public class NotFoundGeometricObjectException extends ClassNotFoundException {
    public NotFoundGeometricObjectException(String message){
        super(message);
    }

    public NotFoundGeometricObjectException(String message, Throwable ex) {
        super(message, ex);
    }
}
