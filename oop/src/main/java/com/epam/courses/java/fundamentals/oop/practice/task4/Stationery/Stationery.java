package com.epam.courses.java.fundamentals.oop.practice.task4.Stationery;

import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

public abstract class Stationery{
  @NonFinal
  double price = 0;

  @NonFinal
  String brand;

  public Stationery(double price, String brand) {
    this.price = price;
    this.brand = brand;
  }

  public int compareTo(@NotNull Stationery o) {
    String a = this.getClass().getSimpleName();
    String b = o.getClass().getSimpleName();
    return a.equals(b) ? Double.compare(this.getPrice(), o.getPrice()) : a.compareTo(b);
  }

  public double getPrice() {
    return price;
  }
}
