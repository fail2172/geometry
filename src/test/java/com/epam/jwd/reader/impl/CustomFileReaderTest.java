package com.epam.jwd.reader.impl;

import com.epam.jwd.entity.GeometricObject;
import com.epam.jwd.reader.CustomFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomFileReaderTest {

    private static final CustomFileReader fileReader = CustomFileReaderImpl.getInstance();
    private static final String TEST_CONE_TXT = "src/test/resources/test_cone.txt";

    @Test
    public void test_shouldReturnListOfGeometricObjects() throws IOException {
        List<GeometricObject> objects = fileReader.readFile(new File(TEST_CONE_TXT));
        Assert.assertNotNull(objects);
    }

    @Test(expectedExceptions = IOException.class)
    public void test_shouldGenerateIOException() throws IOException {
        fileReader.readFile(new File(TEST_CONE_TXT + "a"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void test_shouldGenerateNullPointerException() throws IOException {
        fileReader.readFile(null);
    }

    @Test
    public void test_CheckForSingleton() {
        CustomFileReader otherFileReader = CustomFileReaderImpl.getInstance();
        Assert.assertSame(fileReader, otherFileReader);
    }
}
