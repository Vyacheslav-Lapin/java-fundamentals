package com.epam.courses.java.fundamentals.intro.practice.task4;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

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
    if (as.length == 0) return max;
    if (as.length == 1)
    {
      max = as[0];
      return max;
    } else max = as[0] + as[1];

    for (int i = 0; i < as.length-1; i++) {
       if ((as[i] + as[i+1])>max) max = as[i] + as[i+1];
    }

    return max;
  }

}
