package geometric_object;

import geometric_object.object_context.GeometricObjectContext;

public interface GeometricFactory {
    GeometricObject createObject(GeometricObjectContext context);

    static GeometricFactory instance(){
        return new GeometricObjectFactory();
    }
}
