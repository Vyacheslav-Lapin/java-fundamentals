/* Реализация до fork'a с GitHub'a.
public class Task3 {
    public static void main(String[] args) {
        try {
            if (Double.parseDouble(args[2])>0 && Double.parseDouble(args[0])<Double.parseDouble(args[1])) {
                System.out.println("| x | tan(x) |");
                for (double d = Double.parseDouble(args[0]); d <= Double.parseDouble(args[1]); d += Double.parseDouble(args[2])) {
                    double result = Math.tan(d) - 3;
                    System.out.println("| " + d + " | " + result + " |");}
            } else System.out.println("A must be less then B, and C must be >0.");


        } catch (Exception e) {System.out.println("Program usage: Use only 3 'Double' arguments A B C. There are A - start of X, B is the end of X, C is the step.");}
    }
}

 */
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
    double[][] tableArray = new double[(int)((end-start)/step)+1][2];
    double tableStart=start;
    for (int i=0;i<tableArray.length;i++) {
      tableArray[i]=getDataAndResultPair(tableStart);
      tableStart+=step;
    }
    return tableArray;
  }
}
