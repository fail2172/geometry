package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.geometric_object.GeometricObjectType;
import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;

public class FileReaderValidationImpl implements FileReaderValidation {
    private final static String INCORRECT_INPUT_MESSAGE = "Incorrect input";


    FileReaderValidationImpl() {

    }

    @Override
    public GeometricObjectContext getGeometricObjectContext(String stringContext) throws Exception {

        String[] coneParameters = stringContext.split(";");
        if (coneParameters.length != 3){
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, "incorrect parameters count");
        }

        double height = Double.parseDouble(coneParameters[0]);
        if(height <= 0){
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, "height of cone");
        }

        double radius = Double.parseDouble(coneParameters[1]);
        if(radius <= 0){
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, "radius of cone");
        }

        String[] centerBaseCoordinates = coneParameters[2].split(" ");
        if (centerBaseCoordinates.length != 3){
            throw new IncorrectInputException(INCORRECT_INPUT_MESSAGE, "center base coordinates");
        }

        double x = Double.parseDouble(centerBaseCoordinates[0]);
        double y = Double.parseDouble(centerBaseCoordinates[1]);
        double z = Double.parseDouble(centerBaseCoordinates[2]);

        return GeometricObjectContext.of(GeometricObjectType.CONE, x,y,z).setHeight(height).setRadius(radius).build();
    }
}
