package com.epam.jwd.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeometricContextValidator implements Validator {

    private final static Logger LOG = LogManager.getLogger(GeometricContextValidator.class);

    GeometricContextValidator() {
    }

    @Override
    public boolean checkContext(String stringContext) {
        Properties properties = new Properties();
        try {
            FileInputStream stream = new FileInputStream("src/resources/regular_expression.properties");
            properties.load(stream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            return false;
        }

        Pattern pattern = Pattern.compile(properties.getProperty("coneContextFormat"), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringContext);

        return matcher.matches();
    }
}
