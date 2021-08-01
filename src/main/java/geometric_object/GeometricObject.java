package geometric_object;

import geometric_object.object_context.GeometricObjectContext;

public interface GeometricObject {
    static GeometricObject of(GeometricObjectContext context){
        return switch (context.getType()) {
            case POINT -> new Point(context.getX(), context.getY(), context.getZ());
            case CONE -> new Cone(context.getX(), context.getY(), context.getZ(),
                    context.getHeight(), context.getRadius());
            case CIRCLE -> new Circle(context.getX(), context.getY(), context.getZ(), context.getRadius());
        };
    }
}
