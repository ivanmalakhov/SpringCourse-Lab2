package ru.learn.springtask.log;

import java.io.IOException;

public interface Loggerable {
    void logError(String errorInfo) throws IOException;
    void logData(String logData) throws IOException;
}
