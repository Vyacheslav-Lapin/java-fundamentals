package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task3.*;

import java.util.ArrayList;

public class BeginnerSet {
  ArrayList<Stationery> beginnerSet = new ArrayList<>();

  public ArrayList createSet() {
    beginnerSet.add(new Calculator(150));
    beginnerSet.add(new PaperForNotes(20));
    beginnerSet.add(new BallPen(20));
    beginnerSet.add(new Pencil(10));

    return beginnerSet;
  }

  @Override
  public String toString() {
    return "BeginnerSet{" +
        "beginnerSet=" + new BeginnerSet().createSet() +
        '}';
  }

}
