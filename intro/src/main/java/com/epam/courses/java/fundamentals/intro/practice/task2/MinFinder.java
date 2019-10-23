package com.epam.courses.java.fundamentals.intro.practice.task2;

import static java.lang.Math.pow;
import static java.lang.System.out;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class MinFinder {

  private double e;
  private static ArrayList<Double> numbers = new ArrayList<Double>();

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
    double min = findMin(0.1);
    for (int i = 0; i < numbers.size()-1; i++) {
      out.println(numbers.get(i));

    }
    out.println("Минимальный индекс: " + findMin(0.1));

  }

  @Contract(pure = true)
  private boolean filter(double a) {
    return a < e;
  }

  /***
   *
   * @return
   */
  private int findMin() {
    int n = 1;

    numbers.add(getA(1));
    while(!filter(getA(n))) {
      n += 1;
      numbers.add(getA(n));
    }
    return n;
  }
}
