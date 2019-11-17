package com.epam.courses.java.fundamentals.oop.practice.task4.Stationery;

import lombok.ToString;
import lombok.experimental.NonFinal;
import java.util.ArrayList;

@ToString
public class Instruments extends Stationery {
  @NonFinal
  TYPE type;

  SIZE size;

  public Instruments(double price, String brand, TYPE type, SIZE size) {
    super(price, brand);
    this.type = type;
    this.size = size;
  }
  public Instruments(double price, TYPE type) {
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
}
