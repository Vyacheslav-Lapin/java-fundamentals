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
      out.print("+");
      for (int i = 0; i < 2 * quantity + 3; i++){
        out.print("-");
      }
      out.print("+");
    }

  private void printTop(int quantity, PrintStream out) {
    out.print("+");
    for (int i = 0; i < 2 * quantity + 3; i++)
      out.print("-");
    out.print("+\n|");

    for (int i = 0; i < 2 * quantity; i++){
      if (i == quantity / 2){
        out.print("x");
        continue;
      }
      else if (i == quantity){
        out.print("|");
        continue;
      }
      else if (i == quantity + quantity / 2){
        out.print("f(x)");
        continue;
      }
      else out.print(" ");
    }
    out.print("|\n+");

    for (int i = 0; i < 2 * quantity + 3; i++)
      out.print("-");
    out.println("+");
  }

  public static void main(String[] args) {
    TablePrinter tp= new TablePrinter(0,10, 1);
    tp.printTable(11);
  }

}
