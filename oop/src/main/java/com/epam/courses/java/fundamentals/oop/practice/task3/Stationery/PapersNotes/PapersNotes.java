package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.PapersNotes;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;
import lombok.experimental.NonFinal;

public abstract class PapersNotes extends Stationery {
  @NonFinal
  String format;
  @NonFinal
  long sheets = 0;

  public PapersNotes(double price, String brand, String format, long sheets) {
    super(price, brand);
    this.format = format;
    this.sheets = sheets;
  }
}
