package com.epam.jwd.reader.impl;

import com.epam.jwd.reader.MessageReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class MessageReaderTest {

    private final static MessageReader reader = MessageReaderImpl.getInstance();
    public static final String TEST_MESSAGE_PROPERTIES = "src/test/resources/test_message.properties";

    @Test
    public void test_shouldReturnMessage() {
        Assert.assertNotNull(reader.getMessage(TEST_MESSAGE_PROPERTIES, "POINT"));
        Assert.assertNotNull(reader.getMessage(TEST_MESSAGE_PROPERTIES, "CIRCLE"));
        Assert.assertNotNull(reader.getMessage(TEST_MESSAGE_PROPERTIES, "CONE"));
    }

    @Test
    public void test_CheckForSingleton() {
        MessageReader otherReader = MessageReaderImpl.getInstance();
        Assert.assertSame(reader, otherReader);
    }
}
