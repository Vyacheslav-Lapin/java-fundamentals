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
    double maximum = Double.NEGATIVE_INFINITY;
    for (int i = 0; i<as.length-1; i++){
      double first = as[i];
      double second = as[i+1];
      double sum = first + second;
      maximum = Math.max(maximum, sum);
    }
    return maximum;
  }
}
