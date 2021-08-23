package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.StringToGeometricContext;
import com.epam.jwd.exception.GeometricObjectTypeNotFoundException;
import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import com.epam.jwd.validator.Validator;
import com.epam.jwd.validator.impl.ValidatorImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StringToGeometricContextImpl implements StringToGeometricContext {

    private static final String EXCEPTIONS_PROPERTIES = "src/main/resources/exceptions.properties";
    private static final MessageReader messageReader = MessageReaderImpl.getInstance();
    private static final String SEMICOLON_SEPARATOR = ";";
    private static final String COMMA_SEPARATOR = ",";
    private static StringToGeometricContextImpl instance;
    private static Validator validator;

    StringToGeometricContextImpl() throws FileNotFoundException {
        validator = ValidatorImpl.getInstance();
    }

    public static StringToGeometricContextImpl getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new StringToGeometricContextImpl();
        }
        return instance;
    }

    @Override
    public GeometricContext getContextFromString(String stringContext) throws IncorrectInputException,
            GeometricObjectTypeNotFoundException {
        String[] geometricData = stringContext.split(SEMICOLON_SEPARATOR);
        GeometricObjectType objectType;
        try {
            objectType = GeometricObjectType.getGeometricObjectType(geometricData[0]);
        } catch (GeometricObjectTypeNotFoundException e) {
            throw new IncorrectInputException(messageReader
                    .getMessage(EXCEPTIONS_PROPERTIES, "INCORRECT_INPUT"),
                    new GeometricObjectTypeNotFoundException(messageReader
                            .getMessage(EXCEPTIONS_PROPERTIES, "NOT_FOUND_GEOMETRIC_OBJECT_TYPE")));
        }

        switch (objectType) {
            case CONE:
                return createConeContext(stringContext);
            case CIRCLE:
                return createCircleContext(stringContext);
            case POINT:
                return createPointContext(stringContext);
            default:
                throw new GeometricObjectTypeNotFoundException(messageReader
                        .getMessage(EXCEPTIONS_PROPERTIES, "NOT_FOUND_GEOMETRIC_OBJECT_TYPE"));
        }
    }

    private GeometricContext createConeContext(String stringContext) throws IncorrectInputException {
        if (validator.checkContext(GeometricObjectType.CONE, stringContext)) {

            String[] coneParameters = stringContext.split(SEMICOLON_SEPARATOR);

            double height = Double.parseDouble(coneParameters[1]);
            double radius = Double.parseDouble(coneParameters[2]);

            List<Double> baseCoordinate = getPointCoordinates(coneParameters[3]);

            return GeometricContext
                    .of(GeometricObjectType.CONE, baseCoordinate.get(0), baseCoordinate.get(1), baseCoordinate.get(2))
                    .setHeight(height)
                    .setRadius(radius)
                    .build();
        } else {
            throw new IncorrectInputException(messageReader
                    .getMessage(EXCEPTIONS_PROPERTIES, "INCORRECT_INPUT"));
        }
    }

    private GeometricContext createCircleContext(String stringContext) throws IncorrectInputException {
        if (validator.checkContext(GeometricObjectType.CIRCLE, stringContext)) {

            String[] circleParameters = stringContext.split(SEMICOLON_SEPARATOR);

            double radius = Double.parseDouble(circleParameters[1]);

            List<Double> center = getPointCoordinates(circleParameters[2]);

            return GeometricContext.
                    of(GeometricObjectType.CIRCLE, center.get(0), center.get(1), center.get(2))
                    .setRadius(radius)
                    .build();
        } else {
            throw new IncorrectInputException(messageReader
                    .getMessage(EXCEPTIONS_PROPERTIES, "INCORRECT_INPUT"));
        }
    }

    private GeometricContext createPointContext(String stringContext) throws IncorrectInputException {
        if (validator.checkContext(GeometricObjectType.POINT, stringContext)) {
            List<Double> coordinate = getPointCoordinates(stringContext);

            return GeometricContext
                    .of(GeometricObjectType.CIRCLE, coordinate.get(0), coordinate.get(1), coordinate.get(2))
                    .build();
        } else {
            throw new IncorrectInputException(messageReader
                    .getMessage(EXCEPTIONS_PROPERTIES, "INCORRECT_INPUT"));
        }
    }

    private List<Double> getPointCoordinates(String stringCoordinates) {
        List<Double> pointCoordinate = new ArrayList<>();

        String[] centerBaseCoordinates = stringCoordinates.split(COMMA_SEPARATOR);

        pointCoordinate.add(Double.parseDouble(centerBaseCoordinates[0]));
        pointCoordinate.add(Double.parseDouble(centerBaseCoordinates[1]));
        pointCoordinate.add(Double.parseDouble(centerBaseCoordinates[2]));

        return pointCoordinate;
    }
}
