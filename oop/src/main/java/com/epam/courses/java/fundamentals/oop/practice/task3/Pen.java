package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

public class Pen extends Stationery {

  @NonFinal
  PenType penType;

  public Pen(int cost, int quantity, PenType penType) {
    super(cost, quantity);

    this.penType = penType;
  }

  public PenType getPenType() {
    return penType;
  }

  public void setPenType(PenType penType) {
    this.penType = penType;
  }
}
