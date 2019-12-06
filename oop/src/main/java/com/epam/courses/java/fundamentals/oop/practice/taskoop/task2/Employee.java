package com.epam.courses.java.fundamentals.oop.practice.taskoop.task2;

import com.epam.courses.java.fundamentals.oop.practice.taskoop.task3.Stationery.Stationery;
import lombok.experimental.NonFinal;

import java.util.ArrayList;

public class Employee {
  String name;

  long id;
  @NonFinal
  ArrayList<Stationery> items;

  Employee(String name, long id) {
    this.name = name;
    this.id = id;
    this.items = new ArrayList<>();
  }

  void addNewItem(Stationery stuff){
    items.add(stuff);
  }

  boolean removeStuff(Stationery stuff){
    return items.remove(stuff);
  }

  double getTotalCost(){
    double cost = 0;
    for(Stationery stat:items) cost+=stat.getPrice();
    return cost;
  }
}
