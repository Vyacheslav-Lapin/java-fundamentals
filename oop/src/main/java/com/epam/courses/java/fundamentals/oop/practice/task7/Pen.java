package com.epam.courses.java.fundamentals.oop.practice.task7;

public class Pen {
  private PenType type;
  private String brand;

  public Pen(PenType type, String brand) {
    this.type = type;
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "Pen{" +
        "type=" + type +
        ", brand='" + brand + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pen pen = (Pen) o;
    return type == pen.type &&
        brand.equals(pen.brand);
  }

  @Override
  public int hashCode() {
    return 29 * type.hashCode() + brand.hashCode();
  }
}
