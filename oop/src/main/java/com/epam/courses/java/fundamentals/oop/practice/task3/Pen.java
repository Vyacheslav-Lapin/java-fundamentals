package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Pen extends Stationery {

  public Pen(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Pen{" +
        "price=" + price +
        '}';
  }
}
