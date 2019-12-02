package com.epam.courses.java.fundamentals.strings.task7;
import java.util.Calendar;

public class RunLogger {
  public static void main(String[] args) {
      CrazyLogger logger = CrazyLogger.getLogger();
      logger.log("Log 1");
      logger.log("Log 2");
      logger.log("Log 3");
      logger.printLog();
      System.out.println("__________");
      logger.printLog("Log 2");
      Calendar calendar = Calendar.getInstance();
      logger.printLog(calendar.getTime());
  }
}
