package com.epam.jwd;

import com.epam.jwd.file_reader.CustomFileReader;
import com.epam.jwd.geometric_object.GeometricObject;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.util.List;

public class Run {

    public final static Logger LOG = LogManager.getLogger(Run.class);

    public static void main(String[] args) throws Exception {
        File file = new File("src/resources/test_cone.txt");
        CustomFileReader fileReader = CustomFileReader.instance();
        List<GeometricObject> geometricObjectList = fileReader.readFile(file);

        for (var x : geometricObjectList
             ) {
            LOG.info(x);
        }
    }
}
