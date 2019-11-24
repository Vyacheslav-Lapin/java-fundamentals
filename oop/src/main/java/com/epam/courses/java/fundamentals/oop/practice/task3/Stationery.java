package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

public abstract class Stationery {

  @NonFinal
  public double price;

  public double getPrice() {
    return price;
  }

  public void changePrice(double newPrice) {
    this.price = newPrice;
  }

}



