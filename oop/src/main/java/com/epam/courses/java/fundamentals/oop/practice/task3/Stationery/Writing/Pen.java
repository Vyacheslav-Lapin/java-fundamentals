package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Writing;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;

import java.util.ArrayList;

public class Pen extends Writing {

  INKTYPE inkType;

  enum INKTYPE{REGULAR, GEL, CAPILLAR, LINER}

  private Pen(double price, String brand, Writing.COLOUR colour, INKTYPE inkType) {
    super(price, brand, colour);
    this.inkType = inkType;
  }

  private Pen(double price) {
    super(price, "n/a", COLOUR.BLUE);
    this.inkType = INKTYPE.REGULAR;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Pen(20));
    set.add(new Pen(20));
    set.add(new Pen(20));
    set.add(new Pen(80, "Pilot", COLOUR.BLUE, INKTYPE.GEL));
    return set;
  }
  @Override
  public String toString() {
    return super.toString() + ", " + inkType;
  }
}
