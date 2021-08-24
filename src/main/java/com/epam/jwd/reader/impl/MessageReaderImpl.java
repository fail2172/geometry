package com.epam.jwd.reader.impl;

import com.epam.jwd.reader.MessageReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageReaderImpl implements MessageReader {

    private final static Logger LOG = LogManager.getLogger(MessageReaderImpl.class);
    private final static String EMPTY_STRING = "";
    private static MessageReaderImpl instance;

    MessageReaderImpl() {
    }

    public static MessageReaderImpl getInstance() {
        if (instance == null) {
            instance = new MessageReaderImpl();
        }
        return instance;
    }

    @Override
    public String getMessage(String filePath, String key) {
        Properties properties;
        try (FileInputStream stream = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            LOG.error("file not found! : " + filePath);
            return EMPTY_STRING;
        }

        return properties.getProperty(key);
    }
}
