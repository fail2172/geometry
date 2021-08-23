package com.epam.jwd.validator.impl;

import com.epam.jwd.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class GeometricContextValidatorTest {

    public static Validator validator;

    static {
        try {
            validator = ValidatorImpl.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_CheckForSingleton() throws FileNotFoundException {
        Validator otherValidator = ValidatorImpl.getInstance();
        Assert.assertSame(validator, otherValidator);
    }
}
