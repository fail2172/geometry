package com.epam.jwd.validator;

import com.epam.jwd.reader.MessageReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeometricContextValidator implements Validator {

    private final static MessageReader messageReader = MessageReader.instance();
    private static final String REGULAR_EXPRESSION_PROPERTIES = "src/main/resources/regular_expression.properties";

    GeometricContextValidator() {
    }

    @Override
    public boolean checkContext(String stringContext) {
        Pattern pattern = Pattern.compile(messageReader
                .getMessage(REGULAR_EXPRESSION_PROPERTIES, "CONE_CONTEXT_FORMAT"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringContext);

        return matcher.matches();
    }
}
