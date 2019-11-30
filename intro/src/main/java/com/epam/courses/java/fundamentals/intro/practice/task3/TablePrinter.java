package com.epam.courses.java.fundamentals.intro.practice.task3;

import java.io.PrintStream;

import static java.lang.System.out;

public class TablePrinter {

  private final Table table;

  public TablePrinter(double start, double end, double step) {
    table = new Table(start, end, step);
  }

  public void printTable(int quantity) {
    printTable(quantity, out);
  }

  private void printTable(int quantity, PrintStream out) {

    printTop(quantity, out);

    for (double[] functionResultPair : table.getTable())
      out.printf("|% 3.9f|% 3.9f|\n", functionResultPair[0], functionResultPair[1]);

    printBottom(quantity, out);
  }

  private void printBottom(int quantity, PrintStream out) {
    String strip = strip(quantity + 1);
    out.printf("+%s-%s+\n", strip, strip);
  }

  private String strip(int quantity) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < quantity; i++)
      sb.append("-");

    return sb.toString();
  }

  private void printTop(int quantity, PrintStream out) {
    String strip = strip(quantity + 1);
    out.printf("+%s-%s+\n", strip, strip); // TODO: Сделать ширину каждого заголовка равной quantity
    out.println("|     x     |     f(x)    |");
    out.printf("+%s-%s+\n", strip, strip);
  }
}
