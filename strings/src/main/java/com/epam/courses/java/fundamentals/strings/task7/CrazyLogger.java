package com.epam.courses.java.fundamentals.strings.task7;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class CrazyLogger {

  private static final Calendar calendar = Calendar.getInstance();
  private static final StringBuilder loggerData = new StringBuilder(1024);
  private static CrazyLogger instance;
  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

  private CrazyLogger() {};

    public static CrazyLogger getLogger() {
      if (instance == null) {
        instance = new CrazyLogger();
      }
      return instance;
    }

    private String getLog() {
      return loggerData.toString();
    }

   private String getLog(Date byDate) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
      return getLog(dateFormat.format(byDate));
   }

  private String getLog(String byString) {
    Pattern pattern = Pattern.compile(".*" + byString + ".*\\n");
    Matcher matcher = pattern.matcher(loggerData.toString());
    StringBuilder result = new StringBuilder();
    while (matcher.find()) {
      result.append(matcher.group().trim()).append("\n");
    }
    return result.toString();
  }

  public void log(String message) {
    loggerData.append(dateFormat.format(calendar.getTime()))
        .append(" - ").append(message).append("\n");
  }

  public void printLog() {
    System.out.println(getLog());
  }

  public void printLog(String byString) {
    System.out.println(getLog(byString));
  }

  public void printLog(Date byDate) {
    System.out.println(getLog(byDate));
  }



}
