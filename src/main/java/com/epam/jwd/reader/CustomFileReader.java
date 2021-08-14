package com.epam.jwd.reader;

import com.epam.jwd.entity.GeometricObject;
import com.epam.jwd.reader.impl.CustomFileReaderImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CustomFileReader {
    List<GeometricObject> readFile(File file) throws IOException;

    static CustomFileReader getInstance() {
        return CustomFileReaderImpl.getInstance();
    }
}
