package com.epam.courses.java.fundamentals.oop.practice.task3;

import com.epam.courses.java.fundamentals.oop.practice.task4.Stationery.Stationery;
import lombok.Data;
import lombok.experimental.NonFinal;

import java.util.ArrayList;

/**Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте сотрудника.
 Определите полную стоимость канцтоваров у определенного сотрудника.*/
@Data
public class Employee {
  @NonFinal
  String fullname;
  @NonFinal
  long id;
  @NonFinal
  ArrayList<Stationery> allStuff;

  public Employee(String fullname, long id) {
    this.fullname = fullname;
    this.id = id;
    this.allStuff = new ArrayList<>();
  }

  public void addStuff(Stationery stuff){
    allStuff.add(stuff);
  }

  public boolean removeStuff(Stationery stuff){
    return allStuff.remove(stuff);
  }

  public double getTotalCost(){
    double cost = 0.0;
    for(Stationery stat:allStuff) cost+=stat.getPrice();
    return cost;
  }

}
