package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.Stationery;

public class Pencil extends Stationery {
  @Override
  public String name() {
    return "Pencil";
  }

  @Override
  public double price() {
    return 23;
  }
}
