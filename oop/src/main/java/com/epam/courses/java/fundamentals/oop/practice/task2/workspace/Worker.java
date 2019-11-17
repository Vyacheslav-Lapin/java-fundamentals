package com.epam.courses.java.fundamentals.oop.practice.task2.workspace;

import java.util.ArrayList;
import java.util.List;

public class Worker {

  private String name;
  List<Pen> list;

  Worker(String name) {
    this.name = name;
    list = new ArrayList<>();
  }

  void addToList(Pen pen) {
    list.add(pen);
  }

  List<Pen> getList() {
    return list;
  }

  public String getName() {
    return name;
  }
}
