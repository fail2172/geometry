package com.epam.jwd.validator;

import com.epam.jwd.exception.IncorrectInputException;

public interface Validator {
    boolean checkContext(String stringContext) throws IncorrectInputException;

    static Validator instance(){
        return new GeometricContextValidator();
    }
}
