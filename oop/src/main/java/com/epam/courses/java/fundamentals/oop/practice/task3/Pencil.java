package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Pencil extends Stationery {
  public Pencil(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Pencil{" +
        "price=" + price +
        '}';
  }
}
