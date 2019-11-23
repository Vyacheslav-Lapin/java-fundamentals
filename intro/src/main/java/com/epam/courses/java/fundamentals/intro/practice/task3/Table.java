package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.Math.tan;

public class Table {

  private double start; //a
  private double end; // b
  private double step; // h

  public Table(double start, double end, double step) {

    if (end <= start)
      throw new RuntimeException("End value shoult be bigger then start, but it's not.");

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

    //todo реализовать
    double[][] table = new double[ (int) ((end - start) / step) + 1 ][2];
    int i = 0;
    for (double iterator = start ; iterator <= end; iterator += step) {
      table[i] = getDataAndResultPair(iterator);
      i++;
    }

    return table;
  }
}
