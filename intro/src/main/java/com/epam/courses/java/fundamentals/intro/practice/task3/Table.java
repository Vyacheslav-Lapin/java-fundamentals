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
    int rows = (int) (((end - start) + 1) / step);
    double[][] result = new double[rows][2];
    double data = start;
    int i = 0;
    while (data <= end){
      result[i][0] = getDataAndResultPair(data)[0];
      result[i++][1]= getDataAndResultPair(data)[1];
        data+=step;
    }
    return result;
  }
}
