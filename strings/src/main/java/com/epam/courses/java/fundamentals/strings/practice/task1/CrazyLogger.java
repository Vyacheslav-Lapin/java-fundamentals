package com.epam.courses.java.fundamentals.strings.practice.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrazyLogger {
  StringBuilder stringBuilder;
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY : hh-mm");

  public CrazyLogger() {
    stringBuilder = new StringBuilder();
  }
  //For test
  public void addWithDate(String message) {
    Date notToday = new Date(100, Calendar.NOVEMBER, 10);
    stringBuilder.append(simpleDateFormat.format(notToday)).append(" - ").append(message + "\n");
  }

  public void add(String message) {
    Date today = Calendar.getInstance().getTime();
    stringBuilder.append(simpleDateFormat.format(today)).append(" - ").append(message + "\n");
  }

  public void byMessage(String message) {
    System.out.println("By Message");
    String[] messages = stringBuilder.toString().split("\n");
    boolean isFound = false;
    for (String s : messages) {
      if (s.toLowerCase().contains(message.toLowerCase())) {
        System.out.println(s);
        isFound = true;
      }
    }
    if (!isFound) {
      System.out.println("Message does not found");
    }
  }
  public void byDate(Date date) {
    System.out.println("By Date");
    String[] messages = stringBuilder.toString().split("\n");
    boolean isFound = false;
    for (String s : messages) {
      if (s.contains(simpleDateFormat.format(date))) {
        System.out.println(s);
        isFound = true;
      }
    }
    if (!isFound) {
      System.out.println("Message does not found");
    }
  }
  public void byDateAndMessage(Date date, String message) {
    System.out.println("By Date and Message ");
    String[] messages = stringBuilder.toString().split("\n");
    boolean isFound = false;
    for (String s : messages) {
      if (s.toLowerCase().contains(message.toLowerCase()) && s.contains(simpleDateFormat.format(date))) {
        System.out.println(s);
        isFound = true;
      }
    }
    if (!isFound) {
      System.out.println("Message does not found");
    }
  }
  public void printCrazyLogger() {
    System.out.print(stringBuilder);
  }
}
