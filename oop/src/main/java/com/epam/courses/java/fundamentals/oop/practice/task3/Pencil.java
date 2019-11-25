package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Pencil extends Stationery {

  String name = "pencil";

  @Override
  public String getName() {
    return name;
  }

  public Pencil(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Pencil{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
