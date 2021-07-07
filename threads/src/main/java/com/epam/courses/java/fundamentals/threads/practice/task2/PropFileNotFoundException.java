package com.epam.courses.java.fundamentals.threads.practice.task2;

import java.io.FileNotFoundException;

public class PropFileNotFoundException extends FileNotFoundException {
    public PropFileNotFoundException(String message) {
        super(message);
    }
}
