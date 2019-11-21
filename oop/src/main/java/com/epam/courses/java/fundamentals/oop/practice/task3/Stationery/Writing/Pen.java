package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Writing;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;
import lombok.ToString;
import lombok.experimental.NonFinal;
import java.util.ArrayList;

@ToString
public class Pen extends Writing {

  @NonFinal
  INKTYPE inkType;

  enum INKTYPE{REGULAR, GEL, CAPILLAR, LINER}

  public Pen(double price, String brand, Writing.COLOUR colour, INKTYPE inkType) {
    super(price, brand, colour);
    this.inkType = inkType;
  }

  public Pen(double price) {
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
}
