package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.System.out;

import java.io.PrintStream;

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
    out.print("+-------------------------+");
  }

  private void printTop(int quantity, PrintStream out) {
    // TODO: Сделать ширину каждого заголовка равной quantity
    out.print("+");
    for (int i = 0; i < 2 * quantity; i++)
      out.print("-");
    out.print("+\n|");

    for (int i = 0; i < 2 * quantity; i++) {
      if (i == quantity / 2)
        out.print("x");
      if (i == quantity)
        out.print("|");
      if (i ==  6 * quantity / 4)
        out.print("f(x)");
      out.print(" ");
    }
    out.print("|\n+");

    for (int i = 0; i < 2 * quantity; i++)
      out.print("-");
    out.println("+");
  }
}
