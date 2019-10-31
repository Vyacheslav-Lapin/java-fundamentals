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
    int size = (int)(end-(start/step))+1;
    double x;
    double [][] mass=new double[size][2];
    for (int i=0;step*i<=end;i++){
      x=start+step*i;
      mass[i] = getDataAndResultPair(x);
    }
    return mass;
  }
}
