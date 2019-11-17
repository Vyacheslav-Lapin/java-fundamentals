package com.epam.courses.java.fundamentals.oop.practice.task2.workspace;

import java.util.Comparator;

public class PenNameComparator implements Comparator<Pen> {
  @Override
  public int compare(Pen o1, Pen o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
