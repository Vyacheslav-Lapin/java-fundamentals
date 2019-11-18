package com.epam.courses.java.fundamentals.strings.demo;

public class StringExample1 {

  public static void main(String... __) {
    var sb = new StringBuilder();
    sb.append("Java StringBuilder");
    System.out.println("StringBuilder1 : " + sb); // StringBuilder1 : Java StringBuilder
    sb.append(" Example");
    System.out.println("StringBuilder2 : " + sb); // StringBuilder2 : Java StringBuilder Example
  }
}
