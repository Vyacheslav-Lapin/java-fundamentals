package com.epam.courses.java.fundamentals.strings.practice.task1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger implements Logger {

  private StringBuilder logger;
  private DateTimeFormatter formatter;

  public CrazyLogger() {
    this.logger = new StringBuilder();
    this.formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm-ss");
  }

  private String getDateTime() {
    return formatter.format(LocalDateTime.now());
  }

  @Override
  public void addToLog(@NotNull String str) {
    logger.append(getDateTime())
        .append(" - " + str)
        .append(";")
        .append("\n");
  }

  @Override
  public String getLog() {
    return logger.toString();
  }

  @Override
  public String searchByString(@NotNull String str) {
    String[] logMass = logger.toString().split("\n");
    ArrayList<String> resMass = new ArrayList<>();

    for (int i = 0; i < logMass.length; i++) {
      if (logMass[i].contains(str))
        resMass.add(logMass[i]);
    }

    return resMass.toString();
  }
}
