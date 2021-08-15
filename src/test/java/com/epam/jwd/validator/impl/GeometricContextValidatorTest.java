package com.epam.jwd.validator.impl;

import com.epam.jwd.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeometricContextValidatorTest {

    public static Validator validator = ValidatorImpl.getInstance();

    @Test
    public void test_shouldReturnTrueResult() {
        Assert.assertTrue(validator.checkContext("15.0;10.2;123.5,345.6,789.0"));
    }

    @Test
    public void test_shouldReturnFalseResult() {
        Assert.assertFalse(validator.checkContext("15.0;10.2;123.5   345.6,789.0"));
        Assert.assertFalse(validator.checkContext("15.0;10.2123.5,345.6,789.0"));
        Assert.assertFalse(validator.checkContext("15.0;10.2;123.5,345.6,789..0"));
        Assert.assertFalse(validator.checkContext("15.0;10.2;123.5;345.6,789.0"));
    }

    @Test
    public void test_CheckForSingleton() {
        Validator otherValidator = ValidatorImpl.getInstance();
        Assert.assertSame(validator, otherValidator);
    }
}
