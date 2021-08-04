package com.epam.jwd.file_reader;

import com.epam.jwd.geometric_object.GeometricObject;

import java.io.File;
import java.util.List;

public interface CustomFileReader {
    List<GeometricObject> readFile(File file) throws Exception;

    static CustomFileReader instance() {
        return new CustomFileReaderImpl();
    }
}
