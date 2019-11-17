package com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Writing;

import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Stationery;
import lombok.ToString;
import lombok.experimental.NonFinal;
import java.util.ArrayList;

@ToString
public class Pencil extends Writing {
  @NonFinal
  HARDNESS hard;
  enum HARDNESS{H, HB, B}

  public Pencil(double price, String brand, COLOUR colour, HARDNESS hard) {
    super(price, brand, colour);
    this.hard = hard;
  }

  public Pencil(double price) {
    super(price, "Koh-i-noor", COLOUR.PLAIN);
    this.hard = HARDNESS.HB;
  }

  public static ArrayList<Stationery> getNewbySet() {
    ArrayList<Stationery> set = new ArrayList<>();
    set.add(new Pencil(20));
    set.add(new Pencil(20));
    set.add(new Pencil(20));
    set.add(new Pencil(60, "Derwent", COLOUR.PLAIN, HARDNESS.B));
    return set;
  }
}
