package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

import java.util.ArrayList;
import java.util.List;

public class Employee {

  @NonFinal
  String name;

  @NonFinal
  List<Stationery> stationery = new ArrayList<>();

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Stationery> getStationery() {
    return stationery;
  }

  public int getStationeryCost() {
    int cost = 0;

    for (Stationery stationery : stationery)
      cost += stationery.getCost() * stationery.getQuantity();

    return cost;
  }
}
