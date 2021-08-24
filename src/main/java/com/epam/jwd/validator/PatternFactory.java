package com.epam.jwd.validator;

import com.epam.jwd.entity.impl.GeometricObjectType;

import java.util.regex.Pattern;

public interface PatternFactory {
    Pattern getPattern(GeometricObjectType key);
}
