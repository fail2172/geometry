package validation;

import exception.IncorrectInputException;
import geometric_object.object_context.GeometricObjectContext;

public interface FileReaderValidation {
    GeometricObjectContext getGeometricObjectContext(String stringContext) throws Exception;

    static FileReaderValidation instance(){
        return new FileReaderValidationImpl();
    }
}
