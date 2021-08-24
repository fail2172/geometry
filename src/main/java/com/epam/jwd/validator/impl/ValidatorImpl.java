package com.epam.jwd.validator.impl;

import com.epam.jwd.entity.impl.GeometricObjectType;
import com.epam.jwd.validator.PatternFactory;
import com.epam.jwd.validator.Validator;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;

public class ValidatorImpl implements Validator {

    private static PatternFactory patternFactory;
    private static ValidatorImpl instance;

    ValidatorImpl() throws FileNotFoundException {
        patternFactory = PatternFactoryImpl.getInstance();
    }

    public static ValidatorImpl getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean checkContext(GeometricObjectType key, String stringContext) {
        Matcher matcher = patternFactory.getPattern(key).matcher(stringContext);

        return matcher.matches();
    }
}
