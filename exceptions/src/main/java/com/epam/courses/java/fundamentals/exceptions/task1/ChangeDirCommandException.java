package com.epam.courses.java.fundamentals.exceptions.task1;

public class ChangeDirCommandException extends RuntimeException {
  public ChangeDirCommandException(String msg) {
    super("Can't change directory: "+ msg);
  }
}
