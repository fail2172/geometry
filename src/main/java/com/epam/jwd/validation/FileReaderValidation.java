package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;

public interface FileReaderValidation {
    GeometricObjectContext getGeometricObjectContext(String stringContext) throws IncorrectInputException;

    static FileReaderValidation instance(){
        return new FileReaderValidationImpl();
    }
}
