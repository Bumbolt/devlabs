package com.realdolmen.util;

public class LoggerImpl implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void log(String message, Exception exception) {
        System.out.println(message);
        exception.printStackTrace();
    }
}
