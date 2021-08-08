package com.epam.jwd.entity;

import com.epam.jwd.entity.context.GeometricObjectContext;

public final class GeometricObjectFactory implements GeometricFactory{
    GeometricObjectFactory(){
    }

    @Override
    public GeometricObject createObject(GeometricObjectContext context) {
        return switch (context.getType()) {
            case POINT -> new CustomPoint(context.getX(), context.getY(), context.getZ());
            case CONE -> new Cone(context.getX(), context.getY(), context.getZ(),
                    context.getHeight(), context.getRadius());
            case CIRCLE -> new Circle(context.getX(), context.getY(), context.getZ(), context.getRadius());
        };
    }
}
