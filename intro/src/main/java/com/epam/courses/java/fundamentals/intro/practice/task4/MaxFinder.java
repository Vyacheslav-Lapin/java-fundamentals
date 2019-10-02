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
    //todo реализовать!
    double max = as[0] + as[1];

    for (int i = 2; i < as.length; i++) {
      if ((as[i - 1] + as[i]) > max)
        max = as[i - 1] + as[i];
    }
    return max;
  }
}
