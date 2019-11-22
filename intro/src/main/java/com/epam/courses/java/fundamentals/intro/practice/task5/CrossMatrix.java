package com.epam.courses.java.fundamentals.intro.practice.task5;

public class CrossMatrix {

  private int size;

  public CrossMatrix(int size) {
    this.size = size;
  }

  public boolean get(int x, int y) {
    int lastElem = size - 1;

    if (x == y || x == lastElem - y) {
      return true; // 1
    } else {
      return false; // 0
    }
  }

  @Override
  public String toString() {

    String result = "";

    for (int x = 0; x < size; x++) {
      for (int y = 0; y < size; y++)
        result += get(x, y) ? "1 " : "0 ";
      result += "\n";
    }
    return result;
  }

}
