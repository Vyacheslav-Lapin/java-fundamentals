package com.epam.courses.java.fundamentals.strings.practice.task1;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    var crazyLogger = new CrazyLogger();

    crazyLogger.addToLog("WARNING message one");
    Thread.sleep(1000);

    crazyLogger.addToLog("INFO message one");
    Thread.sleep(1000);

    crazyLogger.addToLog("ERROR message one");

    System.out.println(crazyLogger.getLog());
    System.out.println(crazyLogger.searchByString("INFO"));
    System.out.println(crazyLogger.searchByString("one"));
    System.out.println(crazyLogger.searchByString("two"));
  }
}
