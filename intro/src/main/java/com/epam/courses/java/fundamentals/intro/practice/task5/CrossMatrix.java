package com.epam.courses.java.fundamentals.intro.practice.task5;

import org.w3c.dom.ls.LSOutput;

public class CrossMatrix {
  public static void main(String[] args) {
    CrossMatrix cros = new CrossMatrix(50);
    System.out.println(cros.toString());
  }

  private int size;

  public CrossMatrix(int size) {
    if (size <= 0) {
      System.out.println("Ошибка ввода");
      System.exit(0);
    }
    this.size = size;
  }

  public boolean get(int x, int y) {
    return x == y || (x == size - y - 1);
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
