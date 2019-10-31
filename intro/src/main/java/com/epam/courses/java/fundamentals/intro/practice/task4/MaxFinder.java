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
    if (as.length==1)
      new RuntimeException("Array is too small");
    double max=as[0]+as[1];
    for(int i=1;i<as.length-1;i++)
      if (as[i]+as[i+1]>max)
        max=as[i]+as[i+1];
    return max;
  }
}
