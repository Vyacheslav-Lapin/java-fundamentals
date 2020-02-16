package com.epam.courses.java.fundamentals.strings.practice.task1;

public class TestTask1 {
  public static void main(String[] args) {
    CrazyLoger crazyLoger = new CrazyLoger();
    crazyLoger.addToLog("INFO some message #1");
    crazyLoger.addToLog("WARNING some message #2");
    crazyLoger.addToLog("ERROR some message #3");
    System.out.println(crazyLoger.getLog());
    System.out.println(crazyLoger.search("INFO"));
  }
}
