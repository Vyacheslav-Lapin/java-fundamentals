package com.epam.courses.java.fundamentals.oop.practice.task3;

import lombok.experimental.NonFinal;

import java.util.HashMap;
import java.util.Map;

public class Employee {
  int id;

  String name;

  String surname;

  @NonFinal
  Map<Stationery, Integer> stationeries = new HashMap<>();

  public Employee(int id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
  }

  public void addStationery(Stationery stationery, int quantity) {
    if (!stationeries.containsKey(stationery))
      stationeries.put(stationery, quantity);
    else
      stationeries.put(stationery, stationeries.get(stationery) + quantity);
  }

  public void removeStationery(Stationery stationery, int quantity) {
    if (!stationeries.containsKey(stationery))
      throw new RuntimeException("Employee doesn't have such stationery");
    else if (stationeries.get(stationery) > quantity)
      stationeries.put(stationery, stationeries.get(stationery) - quantity);
    else if (stationeries.get(stationery) == quantity)
      stationeries.remove(stationery);
    else if (stationeries.get(stationery) < quantity)
      throw new RuntimeException("Employee has less quantity of this stationery");
  }

  public double calculatePrice() {
    double sum = 0;
    double price;
    int count;
    for (Map.Entry<Stationery, Integer> entry : stationeries.entrySet()) {
      price = entry.getKey().getPrice();
      count = entry.getValue();
      sum += price * count;
    }

    return sum;
  }

  public Map<Stationery, Integer> getStationeries() {
    return stationeries;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        '}';
  }

}
