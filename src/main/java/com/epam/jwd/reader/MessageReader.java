package com.epam.jwd.reader;

public interface MessageReader {
    String getMessage(String filePath, String key);

    static MessageReader instance(){
        return new MessageReaderImpl();
    }
}
