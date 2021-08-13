package com.epam.jwd.reader;

import com.epam.jwd.exception.IncorrectInputException;
import com.epam.jwd.entity.GeometricFactory;
import com.epam.jwd.entity.GeometricObject;
import com.epam.jwd.entity.context.GeometricContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReaderImpl implements CustomFileReader {

    private static final Logger LOG = LogManager.getLogger(CustomFileReaderImpl.class);

    CustomFileReaderImpl() {
    }

    @Override
    public List<GeometricObject> readFile(File file) throws IOException {
        List<GeometricObject> geometricObjects = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file)) {
            Scanner scanner = new Scanner(fileReader);
            GeometricFactory factory = GeometricFactory.instance();
            int lineNum = 0;

            while (scanner.hasNextLine()) {
                String geometricObjectContext = scanner.nextLine();
                ++lineNum;
                try {
                    GeometricContext context = GeometricContext.stringToContext(geometricObjectContext);
                    geometricObjects.add(factory.createObject(context));
                } catch (IncorrectInputException e) {
                    LOG.error(e.getMessage() + String.format(" : line %s", lineNum));
                }
            }

        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        }

        return geometricObjects;
    }
}
