package com.epam.courses.java.fundamentals.oop.practice.task2;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;
import lombok.experimental.NonFinal;

import java.util.ArrayList;

/**Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте сотрудника.
 Определите полную стоимость канцтоваров у определенного сотрудника.*/

public class Employee {
  String fullname;

  long id;
  @NonFinal
  ArrayList<Stationery> allStuff;

  Employee(String fullname, long id) {
    this.fullname = fullname;
    this.id = id;
    this.allStuff = new ArrayList<>();
  }

  void addStuff(Stationery stuff){
    allStuff.add(stuff);
  }

  boolean removeStuff(Stationery stuff){
    return allStuff.remove(stuff);
  }

  double getTotalCost(){
    double cost = 0.0;
    for(Stationery stat:allStuff) cost+=stat.getPrice();
    return cost;
  }

}
