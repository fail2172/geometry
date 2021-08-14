package com.epam.jwd.reader;

import com.epam.jwd.reader.impl.MessageReaderImpl;

public interface MessageReader {
    String getMessage(String filePath, String key);

    static MessageReader getInstance(){
        return MessageReaderImpl.getInstance();
    }
}
