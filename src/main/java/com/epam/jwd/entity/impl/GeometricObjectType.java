package com.epam.jwd.entity.impl;

import com.epam.jwd.exception.GeometricObjectTypeNotFoundException;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;

public enum GeometricObjectType {
    POINT("point"),
    CONE("cone"),
    CIRCLE("circle");

    private final static String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private final static MessageReader messageReader = MessageReaderImpl.getInstance();
    private final String name;

    GeometricObjectType(String name) {
        this.name = name;
    }

    public static GeometricObjectType getGeometricObjectType(String name) throws GeometricObjectTypeNotFoundException {
        for (GeometricObjectType type : GeometricObjectType.values()
        ) {
            if (type.name.equals(name)) {
                return type;
            }
        }
        throw new GeometricObjectTypeNotFoundException(messageReader.getMessage(EXCEPTIONS_PROPERTIES,
                "NOT_FOUND_GEOMETRIC_OBJECT_TYPE"));
    }

    public String getName() {
        return name;
    }
}
