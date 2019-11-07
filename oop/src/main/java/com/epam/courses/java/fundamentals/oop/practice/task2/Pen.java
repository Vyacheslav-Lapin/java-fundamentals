package com.epam.courses.java.fundamentals.oop.practice.task2;

import java.util.Objects;

public class Pen {
  private Color colorInk;
  private Type type;
  private Mark mark;
  private Integer price;

  public Pen(Color colorInk, Type type, Mark mark, Integer price) {
    this.colorInk = colorInk;
    this.type = type;
    this.mark = mark;
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pen pen = (Pen) o;
    return colorInk == pen.colorInk &&
        type == pen.type &&
        Objects.equals(mark, pen.mark) &&
        Objects.equals(price, pen.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorInk, type, mark, price);
  }

  @Override
  public String toString() {
    return "Pen{" +
        "colorInk=" + colorInk +
        ", type=" + type +
        ", mark='" + mark + '\'' +
        ", price=" + price +
        '}';
  }
}
