package com.epam.courses.java.fundamentals.oop.practice.task4_5;

import lombok.Getter;

import java.util.Comparator;

@Getter
public class Stationery {

  private final String name;
  private final int price;

  public Stationery(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public static Comparator<Stationery> sortByName = new Comparator<Stationery>() {
    @Override
    public int compare(Stationery o1, Stationery o2) {
      return o1.name.compareTo(o2.name);
    }
  };

  public static Comparator<Stationery> sortByPrice = new Comparator<Stationery>() {
    @Override
    public int compare(Stationery o1, Stationery o2) {
      return (int) (o1.price - o2.price);
    }
  };

  public static Comparator<Stationery> sortByPriceAndName = new Comparator<Stationery>() {
    @Override
    public int compare(Stationery o1, Stationery o2) {
      if ((o1.name.compareTo(o2.name)) == 0)
        return o2.price - o1.price;
      else
        return o1.name.compareTo(o2.name);
    }
  };
}
