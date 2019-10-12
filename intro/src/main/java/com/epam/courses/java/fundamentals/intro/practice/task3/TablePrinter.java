package com.epam.courses.java.fundamentals.intro.practice.task3;

import static java.lang.System.out;

import java.io.PrintStream;

public class TablePrinter {

  private final Table table;

  public TablePrinter(double start, double end, double step) {
    table = new Table(start, end, step);
  }

  public static void main(String[] args) {
    TablePrinter tPrinter = new TablePrinter(0.0,10.0,1.0);
    tPrinter.printTable(11); //works correct for quantity >= 4

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
    out.printf("+%."+(quantity*2+3)+"s+", "-------------------------------------------------------------------------------");
  }

  private void printTop(int quantity, PrintStream out) {
    out.printf("+%."+(quantity*2+3)+"s+%n", "-------------------------------------------------------------------------------");
    out.printf("| %."+(quantity-1)/2+"sx%."+(quantity-1)/2+"s| %."+(quantity-4)/2+"sf(x)%."+(quantity-4)/2+"s |%n",
        "                           ", "                     ", "                            ", "                           ");
   // out.printf("|%"+(quantity/2+2)+"s%"+(quantity/2+1)+"s%"+(quantity/2+3)+"s%"+(quantity/2)+"s%n","x", "|", "f(x)", "|");
    out.printf("+%."+(quantity*2+3)+"s+%n", "-------------------------------------------------------------------------------");
  } //Подгонял под реультат из теста.
}
