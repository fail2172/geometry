package com.epam.jwd.validator;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.validator.impl.GeometricContextValidator;

public interface Validator {
    boolean checkContext(String stringContext) throws IncorrectInputException;

    static Validator getInstance(){
        return GeometricContextValidator.getInstance();
    }
}
