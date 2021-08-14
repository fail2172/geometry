package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;
import com.epam.jwd.reader.MessageReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GeometricObjectFactory implements GeometricFactory{

    private final static MessageReader messageReader = MessageReader.instance();
    private final static Logger LOG = LogManager.getLogger(GeometricObjectFactory.class);
    private static final String CREATION_PROPERTIES = "src/main/resources/creation.properties";
    private static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";

    GeometricObjectFactory(){
    }

    @Override
    public GeometricObject createObject(GeometricContext context) throws NotFoundGeometricObjectException {

        switch (context.getType()){
            case POINT:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, "POINT"));
                return new CustomPoint(context.getX(), context.getY(), context.getZ());
            case CIRCLE:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, "CIRCLE"));
                return new Circle(context.getX(), context.getY(), context.getZ(), context.getRadius());
            case CONE:
                LOG.trace(messageReader.getMessage(CREATION_PROPERTIES, "CONE"));
                return new Cone(context.getX(), context.getY(), context.getZ(),
                        context.getHeight(), context.getRadius());
            default:
                throw new NotFoundGeometricObjectException(messageReader
                        .getMessage(EXCEPTIONS_PROPERTIES, "NOT_FOUND_GEOMETRIC_OBJECT"));
        }
    }
}
