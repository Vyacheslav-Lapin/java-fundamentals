package com.epam.courses.java.fundamentals.intro.practice.task4;

/**
 * MaxFinder.
 */
public class MaxFinder {

  private double[] as;

  public MaxFinder(double... as) {
    this.as = as;
  }

  public double getMaximum() {
    double max;
    if (as.length >= 2) {
      max = as[0] + as[1];
    } else {
      max = as[0];
    }
    for (int i = 1; i <= as.length - 2; i++) {
      if (max < as[i] + as[i + 1]) {
        max = as[i] + as[i + 1];
      }
    }
    return max;
  }
}
