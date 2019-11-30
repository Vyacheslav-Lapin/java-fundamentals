package com.epam.courses.java.fundamentals.exceptions.task1;

import lombok.Getter;

public class UnknownCommandException extends Exception {
  @Getter
  private String command;

  public UnknownCommandException(String command) {
    super(("Unknown command '" + command + "'"));
    this.command = command;
  }
}
