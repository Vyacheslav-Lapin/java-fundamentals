package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.Stationery;

public class Notebook extends Stationery {
  @Override
  public String name() {
    return "Notebook";
  }

  @Override
  public double price() {
    return 15;
  }
}
