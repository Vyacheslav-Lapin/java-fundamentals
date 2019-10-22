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


    int iterations = (int)((end-start)/step);
    double[][] mas = new double[iterations+1][2];
    int counter = 0;
    for (double i = start; i <= end; i += step) {
         mas[counter][0] = getDataAndResultPair(i)[0];
         mas[counter][1] = getDataAndResultPair(i)[1];
         counter++;
    }
    return mas;
  }
}
