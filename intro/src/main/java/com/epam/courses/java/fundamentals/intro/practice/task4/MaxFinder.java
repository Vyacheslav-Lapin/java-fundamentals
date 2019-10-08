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
    if (this.as.length == 0) return max;
    if (this.as.length == 1) return as[0];
    for (int i =0; i < (this.as.length-1); i++){
      if(as[i]+as[i+1]>max) max = as[i]+as[i+1];
    }
    return max;
  }
}
