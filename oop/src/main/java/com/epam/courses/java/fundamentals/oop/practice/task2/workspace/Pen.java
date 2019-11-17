package com.epam.courses.java.fundamentals.oop.practice.task2.workspace;

import org.jetbrains.annotations.Contract;

import java.util.List;
import java.util.Objects;

public class Pen {

  private int price;
  private String name;

  public String getName() {
    return name;
  }

  Pen(Worker worker, String name, int price) {
    this.name = name;
    this.price = price;
    worker.addToList(this);
  }

  int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pen)) return false;
    Pen pen = (Pen) o;
    return price == pen.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }

  @Override
  public String toString() {
    return "Pen{" +
        "price=" + price +
        '}';
  }

  private int getSum(Worker worker) {
    int count = 0;
    List<Pen> pens = worker.getList();
    for (Pen pen : pens) {
      count += pen.getPrice();
    }
    return count;
  }
}
