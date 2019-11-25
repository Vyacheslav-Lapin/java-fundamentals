package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

public abstract class Stationery implements Comparable<Stationery> {

  @NonFinal
  String name = "Stationery";

  @NonFinal
  public double price;

  public double getPrice() {
    return price;
  }

  public void changePrice(double newPrice) {
    this.price = newPrice;
  }

  public String getName(){
    return name;
  }

  public int compareTo(Stationery p){

    return name.compareTo(p.getName());
  }
}



