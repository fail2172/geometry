package com.epam.jwd;

import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.epam.jwd.validation.FileReaderValidation;

public class Run {
    public final static Logger LOG = LogManager.getLogger(Run.class);
    public static void main(String[] args) throws Exception {
        String str = new String("5.0;10.0;0.0 0.0 0.0");

        FileReaderValidation fileReaderValidation = FileReaderValidation.instance();

        GeometricObjectContext context = fileReaderValidation.getGeometricObjectContext(str);
        LOG.info(context);
    }
}
