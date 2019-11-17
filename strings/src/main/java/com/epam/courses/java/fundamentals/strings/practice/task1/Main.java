package com.epam.courses.java.fundamentals.strings.practice.task1;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
  public static void main(String[] args) {

    CrazyLogger logger = new CrazyLogger();
    logger.add("Hello");
    logger.add("Hello 2");
    logger.add("Java Hello");
    logger.add("Eva Oleg");

    logger.addWithDate("Hello124");
    logger.addWithDate("Hello1221");
    logger.addWithDate("Hello421");
    logger.addWithDate("Hello2421");
    logger.printCrazyLogger();


   Date today = Calendar.getInstance().getTime();
   logger.byDate(today);

    Date notToday = new Date(100,Calendar.NOVEMBER,10);
   logger.byDate(notToday);

    logger.byMessage("Hello");

    logger.byDateAndMessage(notToday, "Hello");
  }
}
