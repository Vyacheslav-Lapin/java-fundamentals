package com.epam.courses.java.fundamentals.intro.practice.task2;

import static java.lang.Math.*;
import static java.lang.System.*;

import org.jetbrains.annotations.Contract;

public class MinFinder {

  private double e;

  @Contract(pure = true)
  private MinFinder(double e) {
    this.e = e;
  }

  public static double findMin(double e) {
    return new MinFinder(e).findMin();
  }

  @Contract(pure = true)
  private static double getA(int n) {
    return 1 / pow(n + 1, 2);
  }

  public static void main(String... __) {
    out.println("Минимальный индекс: " + findMin(0.1));
  }

  @Contract(pure = true)
  private boolean filter(double a) {
    return a < e;
  }

  private int findMin() {
    //todo реализовать
    return 0;
  }
}
