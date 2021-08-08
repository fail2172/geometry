package com.epam.jwd.geometry.cone;

import com.epam.jwd.reader.CustomFileReader;
import com.epam.jwd.entity.Cone;
import com.epam.jwd.entity.GeometricObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ConeGeometryTest {
    private static final String TEST_CONE_TXT = "src/main/resources/test_cone.txt";
    private static final int CONES_NUM = 5;
    private static final double DELTA = 0.001;
    private final ConeGeometry geometry = ConeGeometry.instance();
    private List<GeometricObject> cones;

    @BeforeTest
    public void initialization() throws Exception {
        CustomFileReader fileReader = CustomFileReader.instance();
        cones = fileReader.readFile(new File(TEST_CONE_TXT));
    }

    @Test
    public void testObjectsListSize(){
        Assert.assertEquals(CONES_NUM, cones.size());
    }

    @Test
    public void testIsCone() {
        Assert.assertTrue(geometry.isCone(cones.get(0)));
    }

    @Test
    public void testBaseOnTheCoordinatePlane() {
        Assert.assertFalse(geometry.baseOnTheCoordinatePlane((Cone) cones.get(0)));
    }

    @DataProvider(name = "Data-Provider")
    public Object[][] SurfaceAreaParameters() {
        return new Object[][]{
                {cones.get(0),new Double[]{1612.0787099530835, 2827.433388230814, 0.14285714285714285}},
                {cones.get(1),new Double[]{22673.342551459165, 83841.77754145321, 0.22036108324974923}},
                {cones.get(2),new Double[]{634.5401102472613, 209.43951023931956, 0.7297297297297297}},
                {cones.get(3),new Double[]{425.77218088885525, 396.490984031607, 0.014759133609948877}},
                {cones.get(4),new Double[]{126.51093268345448, 92.36282401553991, 0.604401650618982}}
        };
    }

    @Test(dataProvider = "Data-Provider")
    public void testSurfaceArea(Cone cone, Double[] expected) {
        Assert.assertEquals(expected[0], geometry.surfaceArea(cone), DELTA);
    }

    @Test(dataProvider = "Data-Provider")
    public void testVolume(Cone cone, Double[] expected) {
        Assert.assertEquals(expected[1], geometry.volume(cone), DELTA);
    }

    @Test(dataProvider = "Data-Provider")
    public void testVolumeRatio(Cone cone, Double[] expected) {
        Assert.assertEquals(expected[2], geometry.volumeRatio(cone), DELTA);
    }
}
