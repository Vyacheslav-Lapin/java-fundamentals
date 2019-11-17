package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

public abstract class Stationery {
  abstract double price();

  abstract String name();

  @Override
  public boolean equals(Object obj) {
    return name() .equals (((Stationery) obj).name());
  }
}
