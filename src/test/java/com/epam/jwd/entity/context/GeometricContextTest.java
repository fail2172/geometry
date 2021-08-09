package com.epam.jwd.entity.context;

import com.epam.jwd.entity.GeometricObjectType;
import com.epam.jwd.exception.IncorrectInputException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

public class GeometricContextTest {

    public static final int X = 0;
    public static final int Z = 0;
    public static final int Y = 0;
    public static final double RADIUS = 10;
    public static final double HEIGHT = 10;

    @Test
    public void of_shouldReturnGeometricContext(){
        GeometricContext context =
                GeometricContext.of(GeometricObjectType.CONE, X, Y, Z).setRadius(RADIUS).setHeight(HEIGHT).build();

        assertNotNull(context);
    }

    @Test
    public void stringToContext_shouldReturnGeometricContext(){
        try {
            GeometricContext context = GeometricContext.stringToContext("10.0;10.0;0.0,0.0,0.0");

            assertNotNull(context);
        } catch (IncorrectInputException e) {
            fail();
        }
    }

    @Test
    public void stringToContext_shouldReturnIncorrectInputException(){
        try {
            GeometricContext.stringToContext("10.0;10.0;;lsdf0.0,0.0,0.0");

            fail();
        } catch (IncorrectInputException e) {
            assertNotNull(e);
        }
    }
}
