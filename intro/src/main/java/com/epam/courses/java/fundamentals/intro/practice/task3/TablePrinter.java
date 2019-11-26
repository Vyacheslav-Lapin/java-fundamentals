package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.System.out;

import java.io.PrintStream;
import java.util.Locale;

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
      out.printf(Locale.ENGLISH,"|% 3.9f|% 3.9f|\n", functionResultPair[0], functionResultPair[1]);

    printBottom(quantity, out);
  }

  private void printBottom(int quantity, PrintStream out) {
    out.print("+-------------------------+");
  }

  private void printTop(int quantity, PrintStream out) {
    // TODO: Сделать ширину каждого заголовка равной quantity
    out.println("+-------------------------+");
    String format = "|%1$-" + quantity + "s|%2$-" + quantity + "s|\n";
    System.out.format(format, "x","f(x)");
    out.println("+-------------------------+");
  }
}
