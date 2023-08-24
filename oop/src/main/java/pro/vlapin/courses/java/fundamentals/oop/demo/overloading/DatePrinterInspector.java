package pro.vlapin.courses.java.fundamentals.oop.demo.overloading;

import java.util.Date;

public class DatePrinterInspector {

  public static void main(String... __) {
    var dp = new DatePrinter();
		int x = dp.printDate("01.01.2015");
		dp.printDate(new Date());
		dp.printDate(1, 1, 2015);
  }
}
