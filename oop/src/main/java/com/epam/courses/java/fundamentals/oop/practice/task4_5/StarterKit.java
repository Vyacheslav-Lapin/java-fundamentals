package com.epam.courses.java.fundamentals.oop.practice.task4_5;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StarterKit {

  private final List<Stationery> stationeryList;

  public StarterKit() {
    this.stationeryList = new ArrayList<>();
  }

  public void printAllElementsInStarterKit() {
    for (Stationery stationery : stationeryList)
      System.out.println(stationery.toString());

    System.out.println();
  }
}
