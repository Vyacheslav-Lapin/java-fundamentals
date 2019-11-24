package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Calculator extends Stationery {

  public Calculator(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Calculator{" +
        "price=" + price +
        '}';
  }
}
