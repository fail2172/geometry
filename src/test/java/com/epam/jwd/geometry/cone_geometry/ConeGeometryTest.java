package com.epam.jwd.geometry.cone_geometry;

import com.epam.jwd.file_reader.CustomFileReader;
import com.epam.jwd.geometric_object.Cone;
import com.epam.jwd.geometric_object.GeometricObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ConeGeometryTest {
    public static final String TEST_CONE_TXT = "src/main/resources/test_cone.txt";
    private final ConeGeometry geometry = ConeGeometry.instance();
    public static final double DELTA = 0.001;
    private List<GeometricObject> objectsList;

    @BeforeTest
    public void initialization() throws Exception {
        CustomFileReader fileReader = CustomFileReader.instance();
        objectsList = fileReader.readFile(new File(TEST_CONE_TXT));
    }

    @Test
    public void testObjectsListSize(){
        Assert.assertEquals(5, objectsList.size());
    }

    @Test
    public void testIsCone() {
        Assert.assertTrue(geometry.isCone(objectsList.get(0)));
    }

    @Test
    public void testBaseOnTheCoordinatePlane() {
        Assert.assertFalse(geometry.baseOnTheCoordinatePlane((Cone) objectsList.get(0)));
    }

    @Test
    public void testSurfaceArea() {
        Assert.assertEquals(75.398223686155, geometry.surfaceArea((Cone) objectsList.get(0)), DELTA);
    }

    @Test
    public void testVolume() {
        Assert.assertEquals(37.69911184307752, geometry.volume((Cone) objectsList.get(0)), DELTA);
    }

    @Test
    public void testVolumeRatio() {
        Assert.assertEquals(0.142857575, geometry.volumeRatio((Cone) objectsList.get(0)), DELTA);
    }
}
