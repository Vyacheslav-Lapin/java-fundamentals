package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.Math.tan;

public class Table {

  private double start; //a
  private double end; // b
  private double step; // h

  public Table(double start, double end, double step) {

    if (end <= start)
      throw new RuntimeException("End value should be bigger than start, but it's not.");

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
    int rows = (int)((end - start + 1) / step);
    int columns = 2;
    double[][] mass = new double[rows][columns];

    double init = start;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns - 1; j++) {
        mass[i][j] = init;
        mass[i][j + 1] = function(init);
        init += step;
      }
    }
    return mass;
  }
}
