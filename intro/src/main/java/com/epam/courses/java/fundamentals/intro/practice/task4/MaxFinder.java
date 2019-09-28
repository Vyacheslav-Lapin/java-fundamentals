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
    double[] sumArray = new double[as.length - 1];
    double max = Double.MIN_VALUE;
    for(int i = 0; i < sumArray.length; i++)
      sumArray[i] = as[i] + as[i + 1];
    for(int i = 0; i < sumArray.length; i++)
      if(sumArray[i] > max)
        max = sumArray[i];
    return max;
  }
}
