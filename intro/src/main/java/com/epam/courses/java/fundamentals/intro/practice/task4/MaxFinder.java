package com.epam.courses.java.fundamentals.intro.practice.task4;

import static java.lang.System.out;

/**
 * MaxFinder.
 */
public class MaxFinder {

  private double[] as;

  public MaxFinder(double... as) {
    this.as = as;
  }

  public static double getMaximum(double[] as) {
    return new MaxFinder(as).getMaximum();
  }

  public double getMaximum() {
    //todo реализовать!
    double max = 0;
    for (int i = 1; i < as.length; i++) {
      double temp = as[i] + as[i - 1];
      out.println(temp);
      if (max < temp)
        max = temp;
    }
    return max;
  }

  public static void main(String... __) {
    int n = (int) Math.round(Math.random() * 20);
    double[] as = new double[n];
    for (int i = 0; i < as.length; i++)
      as[i] = Math.random() * 10;
    out.println("Максимальное значение " + getMaximum(as));
  }
}
