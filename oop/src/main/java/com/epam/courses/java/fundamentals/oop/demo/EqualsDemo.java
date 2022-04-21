package com.epam.courses.java.fundamentals.oop.demo;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.val;

public class EqualsDemo {

  public static void main(String... __) {
    val point1 = new Point(1, 2);
    val point2 = new ColoredPoint(1, 2, 3);
    val point3 = new ColoredPoint(1, 2, 4);

    System.out.println("point1.equals(point2) = " + point1.equals(point2));
    System.out.println("point1.equals(point3) = " + point1.equals(point3));
    System.out.println("point2.equals(point3) = " + point2.equals(point3));
  }
}

@RequiredArgsConstructor
class Point {
  int x;
  int y;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}

class ColoredPoint extends Point {
  int color;

  public ColoredPoint(int x, int y, int color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    ColoredPoint that = (ColoredPoint) o;
    return color == that.color;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), color);
  }
}
