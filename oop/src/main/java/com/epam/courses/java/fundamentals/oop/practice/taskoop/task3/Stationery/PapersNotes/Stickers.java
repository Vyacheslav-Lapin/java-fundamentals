package com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.PapersNotes;

import com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.Stationery;

import java.util.ArrayList;

public class Stickers extends PapersNotes {

  SHAPE shape;

  private static enum SHAPE {SQUARE, RECTANGLE, OTHER}

  private Stickers(double price, String brand, String format, long sheets, SHAPE shape) {
    super(price, brand, format, sheets);
    this.shape = shape;
  }

  private Stickers(double price, String format) {
    super(price, "n/a", format, 100);
    this.shape = SHAPE.SQUARE;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Stickers(50, "B6"));
    set.add(new Stickers(50, "B6"));
    set.add(new Stickers(85, "Komus", "B5", 100, SHAPE.RECTANGLE));
    return set;
  }

  @Override
  public String toString() {
    return super.toString() + ", " + shape;
  }
}
