package com.epam.jwd.entity.impl;

import com.epam.jwd.entity.GeometricFactory;
import com.epam.jwd.entity.GeometricObjectType;
import com.epam.jwd.entity.context.GeometricContext;
import com.epam.jwd.exception.NotFoundGeometricObjectException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeometricFactoryImplTest {

    private final GeometricFactory factory = GeometricFactoryImpl.getInstance();

    @Test
    public void test_ReturnsAllKindsOfGeometricObjects() throws NotFoundGeometricObjectException {
        GeometricContext context =
                GeometricContext.of(GeometricObjectType.CONE, 0, 0, 0).setRadius(5.0).setHeight(10.0).build();
        Assert.assertNotNull(factory.createObject(context));

        context = GeometricContext.of(GeometricObjectType.CIRCLE, 0, 0, 0).setRadius(5.0).build();
        Assert.assertNotNull(factory.createObject(context));

        context = GeometricContext.of(GeometricObjectType.CIRCLE, 0, 0, 0).build();
        Assert.assertNotNull(factory.createObject(context));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void test_shouldReturnNotFoundGeometricObjectException() throws NotFoundGeometricObjectException {
        GeometricContext context = GeometricContext.of(null, 0, 0, 0).build();
        factory.createObject(context);
    }

    @Test
    public void test_CheckForSingleton() {
        GeometricFactory otherFactory = GeometricFactoryImpl.getInstance();
        Assert.assertSame(factory, otherFactory);
    }
}
