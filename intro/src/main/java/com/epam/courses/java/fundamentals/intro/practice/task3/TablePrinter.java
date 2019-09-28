package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.System.out;

import java.io.PrintStream;

public class TablePrinter {

  private final Table table;

  public TablePrinter(double start, double end, double step) {
    table = new Table(start, end, step);
  }

  public static void main(String[] args) {
    TablePrinter tPrinter = new TablePrinter(120.0,230.0,10.9);
    tPrinter.printTable(20); //works correct for quantity > 12
    //сделал quantity не для ширины заголовка, а для всей таблицы.
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
    out.print("+");
    for (int i=0;i<quantity-2;i++) out.print("-");
    out.print("+");
  }

  private void printTop(int quantity, PrintStream out) {
    out.print("+");
    for (int i=0;i<quantity-2;i++) out.print("-");
    out.print("+\n");

    out.print("|");
    for (int i=0;i<(quantity-8)/4;i++) out.print(" ");
    out.print("x");
    for (int i=0;i<(quantity-8)/4;i++) out.print(" ");
    out.print("|");
    for (int i=0;i<(quantity-8)/4;i++) out.print(" ");
    out.print("f(x)");
    for (int i=0;i<(quantity-8)/4;i++) out.print(" ");
    out.print("|\n");

    out.print("+");
    for (int i=0;i<quantity-2;i++) out.print("-");
    out.print("+\n");
  }
}
