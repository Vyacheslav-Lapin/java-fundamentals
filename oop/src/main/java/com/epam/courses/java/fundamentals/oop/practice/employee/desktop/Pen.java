package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

public abstract class Pen extends Stationery{
  public void changeInk(){
    System.out.println(String.format("Refilling the pen that costs %f", price()) );
  }
}
