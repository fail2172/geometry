package com.epam.jwd.geometry.cone_geometry;

import com.epam.jwd.file_reader.CustomFileReader;
import com.epam.jwd.geometric_object.Cone;
import com.epam.jwd.geometric_object.GeometricObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ConeGeometryTest {

    private final ConeGeometry coneGeometry = ConeGeometry.instance();

    @Test
    public void testSurfaceArea() throws Exception {
        CustomFileReader fileReader = CustomFileReader.instance();
        List<GeometricObject> list = fileReader.readFile(new File("src/resources/test_cone.txt"));
        Assert.assertEquals(75.398223686155, coneGeometry.surfaceArea((Cone) list.get(0)), 0.001);
    }

}
