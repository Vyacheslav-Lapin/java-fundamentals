package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.PapersNotes;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;
import lombok.ToString;
import lombok.experimental.NonFinal;
import java.util.ArrayList;

public class PrintPaper extends PapersNotes {

  int density;

  private PrintPaper(double price, String brand) {
    super(price, brand, "A4", 500);
    this.density = 80;
  }

  private PrintPaper(double price, String brand, String format, long sheets, int density) {
    super(price, brand, format, sheets);
    this.density = density;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> result = new ArrayList<>();
    result.add(new PrintPaper(250, "Svetocopy"));
    result.add(new PrintPaper(750, "Svetocopy", "A3", 500, 80));
    return result;
  }

  @Override
  public String toString() {
    return super.toString() + ", "+ density+ " gr/m2";
  }
}
