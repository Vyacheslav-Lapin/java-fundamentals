package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Calculator extends Stationery {

  String name = "calculator";

  @Override
  public String getName() {
    return name;
  }

  public Calculator(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Calculator{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
