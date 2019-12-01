package com.epam.courses.java.fundamentals.web;

public abstract class Parallelogram {
  private int getEqualSides() {
    return 0;
  }

  public void m1() {
    getEqualSides();
  }
}

abstract class Rectangle extends Parallelogram {
  private static int getEqualSides() {
    return 2;
  } // x1

  public static void main(String... __) {
    Rectangle.getEqualSides();
//    new Rectangle(){}.m1();
  }
}

final class Square extends Rectangle {
  public static void main(String[] corners) {
//    Rectangle.getEqualSides();
    final Square myFigure = new Square(); // x3
    System.out.print(myFigure.getEqualSides());
  }

  public int getEqualSides() {
    return 4;
  } // x2
}
