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
    int ROWS = (int) (((end - start) / step + 1));
    int COLUMNS = 2;
    double[][] DataAndResult = new double[ROWS][COLUMNS];
    for (int row = 0; row < ROWS; row += step) {
      for (int column = 0; column < COLUMNS; column++) {
        if (column == 0) {
          DataAndResult[row][column] = row;
        } else {
          DataAndResult[row][column] = function(row);
        }
      }
    }
    return DataAndResult;
  }
}
