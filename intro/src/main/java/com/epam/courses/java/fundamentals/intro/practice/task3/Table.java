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
    int rows = (int) ((end-start)/step) + 1;
    int columns = 2;
    double[][] table = new double[rows][columns];
    for (int row = 0; row<rows; row++){
      double x = start + row*step;
      table[row][0] = x;
      table [row][1] = function(x);
    }


    //todo реализовать
    return table;
  }
}
