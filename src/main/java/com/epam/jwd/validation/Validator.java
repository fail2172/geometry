package com.epam.jwd.validation;

import com.epam.jwd.exception.IncorrectInputException;

public interface Validator {
    void checkContext(String stringContext) throws IncorrectInputException;

    static Validator instance(){
        return new GeometricContextValidator();
    }
}
