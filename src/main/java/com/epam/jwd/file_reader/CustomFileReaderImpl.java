package com.epam.jwd.file_reader;

import com.epam.jwd.Run;
import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.geometric_object.GeometricFactory;
import com.epam.jwd.geometric_object.GeometricObject;
import com.epam.jwd.geometric_object.object_context.GeometricObjectContext;
import com.epam.jwd.validation.FileReaderValidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReaderImpl implements CustomFileReader {
    @Override
    public List<GeometricObject> readFile(File file) throws IOException {
        List<GeometricObject> geometricObjects = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            FileReaderValidation fileReaderValidation = FileReaderValidation.instance();
            GeometricFactory factory = GeometricFactory.instance();

            while (scanner.hasNextLine()) {
                String geometricObjectContext = scanner.nextLine();
                try {
                    GeometricObjectContext context = fileReaderValidation.getGeometricObjectContext(geometricObjectContext);
                    geometricObjects.add(factory.createObject(context));
                } catch (IncorrectInputException e) {
                    Run.LOG.error(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            Run.LOG.error(e.getMessage());
        }

        return geometricObjects;
    }
}
