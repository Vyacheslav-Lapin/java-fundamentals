package com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery;

import org.jetbrains.annotations.NotNull;

abstract public class Stationery{

  double price;

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

  @Override
  public String toString() {
    return this.brand.equals("n/a") ? this.getClass().getSimpleName() + ": " + "price = " + price:
        this.getClass().getSimpleName() + ": " + brand + ", price = " + price;
  }
}
