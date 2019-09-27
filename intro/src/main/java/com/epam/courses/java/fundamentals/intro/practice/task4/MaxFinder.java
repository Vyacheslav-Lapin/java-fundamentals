package com.epam.courses.java.fundamentals.intro.practice.task4;

import java.util.Arrays;

/**
 * MaxFinder.
 */
public class MaxFinder {

  private double[] as;

  public MaxFinder(double... as) {
    this.as = as;
  }

  public double getMaximum() {
    double max = 0;
    for (int i = 0; i < as.length - 1; i++) {
      double res = as[i] + as[i + 1];
      if (res > max) max = res;
    }
    return max;
  }
}
