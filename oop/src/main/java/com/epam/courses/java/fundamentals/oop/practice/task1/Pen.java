package com.epam.courses.java.fundamentals.oop.practice.task1;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;

/**
 * Разработайте спецификацию и создайте класс Ручка (Pen). Определите в этом классе
 * Методы:
 * · equals(),
 * · hashCode() и
 * · toString().
 */
@AllArgsConstructor
class Pen {

  String brand;

  String colour;

  String inkType;

  long price;

  @Override
  public int hashCode() {
    return (int) (31 + ((brand == null) ? 0 : brand.hashCode()) + ((colour == null) ? 0 : colour.hashCode()) +
        ((inkType == null) ? 0 : inkType.hashCode()) + price * 17);
  }

  @Override
  @Contract(value = "null -> false", pure = true)
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Pen)) return false;
    Pen pen = (Pen) obj;
    return (price == pen.price) && brand.equals(pen.brand) && colour.equals(pen.colour) && inkType.equals(pen.inkType);
  }

  @Override
  public String toString() {
    return colour + " " + inkType + " " + brand + " pen, price = " + price;
  }
}
