package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;

public class GeometricContextValidator implements Validator {
    private final static String INCORRECT_INPUT_MESSAGE = "Incorrect input";
    private final static String PARAMETERS_COUNT = "incorrect parameters count";
    private final static String HEIGHT_OF_CONE = "height of cone";
    private final static String RADIUS_OF_CONE = "radius of cone";
    private final static String BASE_COORDINATES = "center base coordinates";
    private final static String SEMICOLON_SEPARATOR = ";";
    private final static String SPACE_SEPARATOR = " ";

    GeometricContextValidator() {

    }

    @Override
    public void checkContext(String stringContext) throws IncorrectInputException {
        String[] coneParameters = stringContext.split(SEMICOLON_SEPARATOR);
        if (coneParameters.length != 3) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, PARAMETERS_COUNT);
        }

        try {
            double height = Double.parseDouble(coneParameters[0]);
            if (height <= 0) {
                throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, HEIGHT_OF_CONE);
            }
        } catch (NumberFormatException e) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, HEIGHT_OF_CONE);
        }

        try {
            double radius = Double.parseDouble(coneParameters[1]);
            if (radius <= 0) {
                throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, RADIUS_OF_CONE);
            }
        } catch (NumberFormatException e) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, RADIUS_OF_CONE);
        }

        String[] centerBaseCoordinates = coneParameters[2].split(SPACE_SEPARATOR);
        if (centerBaseCoordinates.length != 3) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, BASE_COORDINATES);
        }

        try {
            Double.parseDouble(centerBaseCoordinates[0]);
            Double.parseDouble(centerBaseCoordinates[1]);
            Double.parseDouble(centerBaseCoordinates[2]);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, BASE_COORDINATES);
        }
    }
}
