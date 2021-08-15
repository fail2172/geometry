package com.epam.jwd.validator.impl;

import com.epam.jwd.reader.MessageReader;
import com.epam.jwd.reader.impl.MessageReaderImpl;
import com.epam.jwd.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {

    private static ValidatorImpl instance;

    private final static MessageReader messageReader = MessageReaderImpl.getInstance();
    private static final String REGULAR_EXPRESSION_PROPERTIES = "src/main/resources/regular_expression.properties";

    ValidatorImpl() {
    }

    public static ValidatorImpl getInstance() {
        if (instance == null) {
            instance = new ValidatorImpl();
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
