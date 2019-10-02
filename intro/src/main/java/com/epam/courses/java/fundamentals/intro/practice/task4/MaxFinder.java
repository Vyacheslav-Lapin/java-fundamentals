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
    double max = -1.0;
    for(int i = 0; i < as.length - 2; i++){
      double sum = as[i] + as[i+1];
      max = Math.max(max,sum);
    }
    return max;
  }
}
