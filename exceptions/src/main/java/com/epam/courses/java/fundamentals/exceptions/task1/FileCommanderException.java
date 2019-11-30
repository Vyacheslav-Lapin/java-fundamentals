package com.epam.courses.java.fundamentals.exceptions.task1;

import java.security.AccessControlException;

public class FileCommanderException extends RuntimeException {
  public FileCommanderException(String msg, AccessControlException ex) {
    super(msg, ex);
  }
}
