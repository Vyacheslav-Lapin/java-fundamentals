package com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Writing;

import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Stationery;
import lombok.experimental.NonFinal;

public abstract class Writing extends Stationery {
  @NonFinal
  COLOUR colour;

  enum COLOUR {PLAIN, BLUE, BLACK, GREEN, RED, MULTICOURED}

  public Writing(double price, String brand, COLOUR colour) {
    super(price, brand);
    this.colour = colour;
  }
}
