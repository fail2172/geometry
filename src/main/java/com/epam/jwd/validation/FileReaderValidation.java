package com.epam.jwd.validation;

import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;

public interface FileReaderValidation {
    GeometricObjectContext getGeometricObjectContext(String stringContext) throws Exception;

    static FileReaderValidation instance(){
        return new FileReaderValidationImpl();
    }
}
