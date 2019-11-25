package com.epam.courses.java.fundamentals.oop.practice.task3.Stationery;

import lombok.ToString;

import java.util.ArrayList;

public class Clips extends Stationery {

  int packSize;

  SIZE size;

  TYPE type;

  enum SIZE {SMALL, REGULAR, BIG}

  enum TYPE {PAPERCLIPS, STAPLES, PINS}

  private Clips(double price, String brand, int packSize, SIZE size, TYPE type) {
    super(price, brand);
    this.packSize = packSize;
    this.size = size;
    this.type = type;
  }

  private Clips(double price, TYPE type) {
    super(price, "n/a");
    this.packSize = 100;
    this.size = SIZE.REGULAR;
    this.type = type;
  }

  @Override
  public String toString() {
    return super.toString() + ", "  + size + " " + type + "pack of: " + packSize;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Clips(100, TYPE.PAPERCLIPS));
    set.add(new Clips(180, "n/a", 50, SIZE.BIG, TYPE.PAPERCLIPS));
    set.add(new Clips(80, TYPE.STAPLES));
    return set;
  }

}
