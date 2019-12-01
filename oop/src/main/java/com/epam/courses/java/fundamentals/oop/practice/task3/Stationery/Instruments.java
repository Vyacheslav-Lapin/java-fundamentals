package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery;

import java.util.ArrayList;

public class Instruments extends Stationery {

  TYPE type;

  SIZE size;

  private Instruments(double price, String brand, TYPE type, SIZE size) {
    super(price, brand);
    this.type = type;
    this.size = size;
  }

  private Instruments(double price, TYPE type) {
    super(price, "n/a");
    this.type = type;
    this.size = SIZE.REGULAR;
  }

  private static enum TYPE {HOLEPUNCHER, STAPLER, SHARPENER}
  private static enum SIZE {SMALL, REGULAR, BIG}

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Instruments(1200, TYPE.HOLEPUNCHER));
    set.add(new Instruments(50, TYPE.SHARPENER));
    set.add(new Instruments(250, TYPE.STAPLER));
    set.add(new Instruments(400, "n/a", TYPE.STAPLER, SIZE.BIG));
    return set;
  }

  @Override
  public String toString() {
    return super.toString() + ", "  + size + " " + type;
  }
}
