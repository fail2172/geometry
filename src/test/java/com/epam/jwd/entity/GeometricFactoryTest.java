package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeometricFactoryTest {

    private final GeometricFactory factory = GeometricFactory.instance();

    @Test
    public void test_ReturnsAllKindsOfGeometricObjects(){
        GeometricContext context =
                GeometricContext.of(GeometricObjectType.CONE, 0,0,0).setRadius(5.0).setHeight(10.0).build();
        Assert.assertNotNull(factory.createObject(context));

        context = GeometricContext.of(GeometricObjectType.CIRCLE, 0,0,0).setRadius(5.0).build();
        Assert.assertNotNull(factory.createObject(context));

        context = GeometricContext.of(GeometricObjectType.CIRCLE, 0,0,0).build();
        Assert.assertNotNull(factory.createObject(context));
    }
}
