package com.epam.courses.java.fundamentals.intro.practice.task5;

public class CrossMatrix {

  private int size;

  public CrossMatrix(int size) {
    this.size = size;
  }

  public boolean get(int x, int y) {
    return x == y || size - x - 1 == y;
  }

  @Override
  public String toString() {

    StringBuilder result = new StringBuilder();

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++)
        result.append(get(x, y) ? "1 " : "0 ");
      result.append("\n");
    }
    return result.toString();
  }
}
