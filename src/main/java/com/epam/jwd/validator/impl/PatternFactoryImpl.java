package com.epam.jwd.validator.impl;

import com.epam.jwd.entity.impl.GeometricObjectType;
import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import com.epam.jwd.validator.PatternFactory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternFactoryImpl implements PatternFactory {

    private static PatternFactoryImpl instance;

    private final Map<GeometricObjectType, Pattern> patternMap = new HashMap<>();

    public static PatternFactoryImpl getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new PatternFactoryImpl();
        }
        return instance;
    }

    PatternFactoryImpl() {
        final String REGULAR_EXPRESSION_PROPERTIES = "src/main/resources/regular_expression.properties";
        final MessageReader regularExpressionReader = MessageReaderImpl.getInstance();

        patternMap.put(GeometricObjectType.CONE, Pattern.compile(regularExpressionReader
                .getMessage(REGULAR_EXPRESSION_PROPERTIES, GeometricObjectType.CONE.getName()), Pattern.CASE_INSENSITIVE));
        patternMap.put(GeometricObjectType.CIRCLE, Pattern.compile(regularExpressionReader
                .getMessage(REGULAR_EXPRESSION_PROPERTIES, GeometricObjectType.CIRCLE.getName()), Pattern.CASE_INSENSITIVE));
        patternMap.put(GeometricObjectType.POINT, Pattern.compile(regularExpressionReader
                .getMessage(REGULAR_EXPRESSION_PROPERTIES, GeometricObjectType.POINT.getName()), Pattern.CASE_INSENSITIVE));
    }

    @Override
    public Pattern getPattern(GeometricObjectType key) {
        return patternMap.get(key);
    }
}
