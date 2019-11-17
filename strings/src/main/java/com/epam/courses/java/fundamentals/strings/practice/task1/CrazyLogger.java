package com.epam.courses.java.fundamentals.strings.practice.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrazyLogger {
  StringBuilder storage;
  SimpleDateFormat format = new SimpleDateFormat("dd-mm-YYYY : hh-mm");

  public CrazyLogger() {
    storage = new StringBuilder();
  }

  public void add(String message) {
    Date currentDate = Calendar.getInstance().getTime();
    storage.append(format.format(currentDate)).append(" - ").append(message + "\n");
  }


  public void printContent() {
    System.out.print(storage);
  }
}
