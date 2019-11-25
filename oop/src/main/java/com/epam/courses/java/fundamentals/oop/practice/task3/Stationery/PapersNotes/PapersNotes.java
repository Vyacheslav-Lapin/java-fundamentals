package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.PapersNotes;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;

public abstract class PapersNotes extends Stationery {
  String format;

  long sheets;

  PapersNotes(double price, String brand, String format, long sheets) {
    super(price, brand);
    this.format = format;
    this.sheets = sheets;
  }

  @Override
  public String toString() {
    return super.toString() + ", "  + format + " (" + sheets + ")";
  }
}
