package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.Math.tan;

public class Table {

  private double start; //a
  private double end; // b
  private double step; // h

  public Table(double start, double end, double step) {

    if (end <= start)
      throw new RuntimeException("End value should be bigger then start, but it's not.");

    this.start = start;
    this.end = end;
    this.step = step;
  }

  static double[] getDataAndResultPair(double x) {
    return new double[]{x, function(x)};
  }

  static double function(double x) {
    return tan(2 * x) - 3;
  }

  public double[][] getTable() {
    double[][] result = new double[(int) ((end - start + 1) / step)][2];
    int met = 0;
    for (int index = (int) start; index <= end; index += step) {
      result[met][0] = index;
      result[met][1] = function(index);
      met++;
    }
    return result;
  }
}
