package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

public class Stationery {

  @NonFinal
  int cost;

  @NonFinal
  int quantity;

  public Stationery(int cost, int quantity) {
    this.cost = cost;
    this.quantity = quantity;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
