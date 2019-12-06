package com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.PapersNotes;

import com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.Stationery;

import java.util.ArrayList;

public class PrintPaper extends PapersNotes {

  int density;

  private PrintPaper(double price, String brand) {
    super(price, brand, "A4", 100);
    this.density = 50;
  }

  private PrintPaper(double price, String brand, String format, long sheets, int density) {
    super(price, brand, format, sheets);
    this.density = density;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> result = new ArrayList<>();
    result.add(new PrintPaper(150, "OldBrand"));
    result.add(new PrintPaper(500, "NewBrand", "A4", 300, 50));
    result.add(new PrintPaper(200, "OldBrand", "A3", 200, 50));
    return result;
  }

  @Override
  public String toString() {
    return super.toString() + ", "+ density+ " g/m2";
  }
}
