package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.*;
import com.epam.jwd.exception.GeometricObjectTypeNotFoundException;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GeometricFactoryImpl implements GeometricFactory {

    private static GeometricFactoryImpl instance;

    public final static MessageReader messageReader = MessageReaderImpl.getInstance();
    private final static Logger LOG = LogManager.getLogger(GeometricFactoryImpl.class);
    private final static String CREATION_PROPERTIES = "src/main/resources/creation.properties";
    private final static String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";

    GeometricFactoryImpl() {
    }

    public static GeometricFactoryImpl getInstance() {
        if (instance == null) {
            instance = new GeometricFactoryImpl();
        }
        return instance;
    }

    @Override
    public GeometricObject createObject(GeometricContext context) throws GeometricObjectTypeNotFoundException {
        switch (context.getType()) {
            case POINT:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, GeometricObjectType.CONE.getName()));
                return new CustomPoint(context.getX(), context.getY(), context.getZ());
            case CIRCLE:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, GeometricObjectType.CIRCLE.getName()));
                return new Circle(context.getX(), context.getY(), context.getZ(), context.getRadius());
            case CONE:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, GeometricObjectType.POINT.getName()));
                return new Cone(context.getX(), context.getY(), context.getZ(),
                        context.getHeight(), context.getRadius());
            default:
                throw new GeometricObjectTypeNotFoundException(messageReader
                        .getMessage(EXCEPTIONS_PROPERTIES, "NOT_FOUND_GEOMETRIC_OBJECT_TYPE"));
        }
    }
}
