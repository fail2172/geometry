package com.epam.jwd.reader.impl;

import com.epam.jwd.reader.MessageReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MessageReaderImpl implements MessageReader {

    private final static Logger LOG = LogManager.getLogger(MessageReaderImpl.class);
    private static MessageReaderImpl instance;

    private Properties properties = null;

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
        try (FileInputStream stream = new FileInputStream(filePath)) {
            properties = new Properties();
            properties.load(stream);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

        return properties.getProperty(key);
    }
}
