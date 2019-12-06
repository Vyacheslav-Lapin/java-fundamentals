package com.epam.courses.java.fundamentals.oop.practice.taskoop.task1;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;

@AllArgsConstructor
class Pen {

  String brand, colour, type;

  double price;

  @Override
  public int hashCode() {
    return (int) (31 + ((brand == null) ? 0 : brand.hashCode()) + ((colour == null) ? 0 : colour.hashCode()) +
        ((type == null) ? 0 : type.hashCode()) + price * 17);
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pen)) return false;
    Pen pen = (Pen) o;
    return (price == pen.price) && brand.equals(pen.brand) && colour.equals(pen.colour) && type.equals(pen.type);
  }

  @Override
  public String toString() {
    return colour + " " + type + " " + brand + " pen, price = " + price;
  }
}
