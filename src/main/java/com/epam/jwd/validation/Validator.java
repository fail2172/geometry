package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;

public interface FileReaderValidation {
    void getGeometricObjectContext(String stringContext) throws IncorrectInputException;

    static FileReaderValidation instance(){
        return new FileReaderValidationImpl();
    }
}
