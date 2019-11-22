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
    double max = 0.0;
    double elem = 0.0;

    for (int i = 0; i < as.length - 1; i++) {
      elem = as[i] + as[i + 1];

      if (elem > max) {
        max = elem;
      }
    }

    return max;
  }
}
