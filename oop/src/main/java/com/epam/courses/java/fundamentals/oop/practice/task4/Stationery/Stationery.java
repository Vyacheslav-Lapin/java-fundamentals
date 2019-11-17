package com.epam.courses.java.fundamentals.oop.practice.task4.Stationery;

import lombok.experimental.NonFinal;

public abstract class Stationery {
  @NonFinal
  double price = 0;

  @NonFinal
  String brand;

  public Stationery(double price, String brand) {
    this.price = price;
    this.brand = brand;
  }
}
