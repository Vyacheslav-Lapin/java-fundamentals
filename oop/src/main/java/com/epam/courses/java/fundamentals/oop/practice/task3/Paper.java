package com.epam.courses.java.fundamentals.oop.practice.task3;

public class Paper extends Stationery{

  public Paper(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Paper{" +
        "price=" + price +
        '}';
  }
}
