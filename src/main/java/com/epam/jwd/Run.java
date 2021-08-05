package com.epam.jwd;

import com.epam.jwd.file_reader.CustomFileReader;
import com.epam.jwd.geometric_object.Cone;
import com.epam.jwd.geometric_object.GeometricFactory;
import com.epam.jwd.geometric_object.GeometricObject;
import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;
import com.epam.jwd.geometry.cone_geometry.ConeGeometry;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.List;

public class Run {

    public final static Logger LOG = LogManager.getLogger(Run.class);

    public static void main(String[] args) throws Exception {
        File file = new File("src/resources/cone.txt");
        CustomFileReader fileReader = CustomFileReader.instance();
        List<GeometricObject> geometricObjectList = fileReader.readFile(file);

        for (var x : geometricObjectList
             ) {
            LOG.info(x);
        }

//        GeometricObjectContext context = GeometricObjectContext.stringToContext("10.0;10;1.0 0.0 0.0");
//        GeometricFactory factory = GeometricFactory.instance();
//        Cone cone = (Cone) factory.createObject(context);
//
//        ConeGeometry geometry = ConeGeometry.instance();
//
//        LOG.info(geometry.volume(cone));
    }
}
