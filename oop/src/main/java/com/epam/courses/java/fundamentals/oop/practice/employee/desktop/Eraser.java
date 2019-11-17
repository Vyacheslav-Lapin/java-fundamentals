package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.Stationery;

public class Eraser extends Stationery {
  @Override
  public double price() {
    return 4;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String name() {
    return "Eraser";

  }
}
