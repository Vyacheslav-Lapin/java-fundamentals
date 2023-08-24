package pro.vlapin.courses.java.fundamentals.oop.demo.records;

//public record Person (String firstName, String lastName, LocalDate dob) {
//}

//public record Point (int x, int y) { }

import java.util.Objects;

public final class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  public int hashCode() {
    return Objects.hash(x, y);
  }

  public String toString() {
    return "Point{" +
           "x=" + x +
           ", y=" + y +
           '}';
  }
}

//  public static void main(String[] args) {
//    System.out.println("person = " + new Person("Вася", "Пупкин", LocalDate.parse("2007-12-03")));
//  }
