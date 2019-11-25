package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task3.Pen;

public class BallPen extends Pen {
  String name = "ball pen";

  @Override
  public String getName() {
    return name;
  }

  public BallPen(double price) {
    super(price);
  }

  @Override
  public String toString() {
    return "BallPen{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
