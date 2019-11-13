package com.epam.courses.java.fundamentals.oop.practice.task4_5;

import lombok.Getter;

@Getter
public class Pen extends Stationery {

  private final PenType penType;
  private final InkColor inkColor;

  public Pen(String name, int price, PenType penType, InkColor inkColor) {
    super(name, price);
    this.penType = penType;
    this.inkColor = inkColor;
  }

  @Override
  public String toString() {
    return "Pen{" +
        "name=" + getName() +
        ", price=" + getPrice() +
        ", penType=" + penType +
        ", inkColor=" + inkColor +
        '}';
  }
}
