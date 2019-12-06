package com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.Writing;

import com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.Stationery;

import java.util.ArrayList;

public class Pen extends Writing {

  TYPE type;

  enum TYPE{REGULAR, GEL, OTHER}

  private Pen(double price, String brand, Writing.COLOUR colour, TYPE type) {
    super(price, brand, colour);
    this.type = type;
  }

  private Pen(double price) {
    super(price, "Parker", COLOUR.RED);
    this.type = TYPE.GEL;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Pen(20));
    set.add(new Pen(20));
    set.add(new Pen(20));
    set.add(new Pen(80, "Bic", COLOUR.BLACK, TYPE.REGULAR));
    return set;
  }
  @Override
  public String toString() {
    return super.toString() + ", " + type;
  }
}
