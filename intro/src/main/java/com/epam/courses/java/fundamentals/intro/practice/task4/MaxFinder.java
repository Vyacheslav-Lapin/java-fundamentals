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
    double max = as[0];
    for (int i = 0; i < as.length - 1; i++) {
      double a = as[i] + as[i + 1];
      if (a > max) {
        max = a;
      }
    }
    return max;
  }
  // for test 
 // public static void main(String[] args) {
 //   MaxFinder maxFinder = new MaxFinder(0.2, 0.7, 10, 83, 3.0, 0.9);
 //   System.out.println(maxFinder.getMaximum());
 // }
}


