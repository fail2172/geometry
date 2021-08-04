package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.geometric_object.GeometricObjectType;
import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;

import java.util.regex.Pattern;

public class FileReaderValidationImpl implements FileReaderValidation {
    private final static String INCORRECT_INPUT_MESSAGE = "Incorrect input";
    private final static String PARAMETERS_COUNT = "incorrect parameters count";
    private final static String HEIGHT_OF_CONE = "height of cone";
    private final static String RADIUS_OF_CONE = "radius of cone";
    private final static String BASE_COORDINATES = "center base coordinates";

    FileReaderValidationImpl() {

    }

    @Override
    public void getGeometricObjectContext(String stringContext) throws IncorrectInputException {
        String[] coneParameters = stringContext.split(";");
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

        String[] centerBaseCoordinates = coneParameters[2].split(" ");
        if (centerBaseCoordinates.length != 3) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, BASE_COORDINATES);
        }

        try {
            double x = Double.parseDouble(centerBaseCoordinates[0]);
            double y = Double.parseDouble(centerBaseCoordinates[1]);
            double z = Double.parseDouble(centerBaseCoordinates[2]);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, BASE_COORDINATES);
        }
    }
}
