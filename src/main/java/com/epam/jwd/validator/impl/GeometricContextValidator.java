package com.epam.jwd.validator.impl;

import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import com.epam.jwd.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeometricContextValidator implements Validator {

    private static GeometricContextValidator instance;

    private final static MessageReader messageReader = MessageReaderImpl.getInstance();
    private static final String REGULAR_EXPRESSION_PROPERTIES = "src/main/resources/regular_expression.properties";

    GeometricContextValidator() {
    }

    public static GeometricContextValidator getInstance() {
        if (instance == null) {
            instance = new GeometricContextValidator();
        }
        return instance;
    }

    @Override
    public boolean checkContext(String stringContext) {
        Pattern pattern = Pattern.compile(messageReader
                .getMessage(REGULAR_EXPRESSION_PROPERTIES, "CONE_CONTEXT_FORMAT"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringContext);

        return matcher.matches();
    }
}
