package com.epam.jwd.geometric_object;

import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;

public class GeometricObjectFactory implements GeometricFactory{
    GeometricObjectFactory(){
    }

    @Override
    public GeometricObject createObject(GeometricObjectContext context) {
        return switch (context.getType()) {
            case POINT -> new Point(context.getX(), context.getY(), context.getZ());
            case CONE -> new Cone(context.getX(), context.getY(), context.getZ(),
                    context.getHeight(), context.getRadius());
            case CIRCLE -> new Circle(context.getX(), context.getY(), context.getZ(), context.getRadius());
        };
    }
}
