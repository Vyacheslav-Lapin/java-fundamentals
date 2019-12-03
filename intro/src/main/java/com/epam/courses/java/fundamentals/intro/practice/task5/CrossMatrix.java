package com.epam.courses.java.fundamentals.intro.practice.task5;

public class CrossMatrix {

  private int size;

  public CrossMatrix(int size) {
    this.size = size;
  }

  public boolean get(int x, int y) {
    return x == y || x + y == (size - 1);
  }

  @Override
  public String toString() {

    String result = "";

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++) {
        result += get(x, y) ? "1 " : "0 ";
        result += "";
      }
      result += "\n";
    }
    return result;
  }
}
