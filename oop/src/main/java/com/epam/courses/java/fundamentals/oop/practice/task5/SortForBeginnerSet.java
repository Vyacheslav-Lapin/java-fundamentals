package com.epam.courses.java.fundamentals.oop.practice.task5;

import com.epam.courses.java.fundamentals.oop.practice.task4.*;
import com.epam.courses.java.fundamentals.oop.practice.task3.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortForBeginnerSet {
  BeginnerSet set = new BeginnerSet();
  ArrayList<Stationery> beginnerSet = set.createSet();

  public ArrayList<Stationery> sortByPrice() {
    Collections.sort(beginnerSet, (o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
    return beginnerSet;
  }

  public ArrayList<Stationery> sortByName() {
    Collections.sort(beginnerSet, Comparator.comparing(Stationery::getName));
    return beginnerSet;
  }

  public ArrayList<Stationery> sortByPriceAndName() {
    Collections.sort(beginnerSet, new Comparator<Stationery>() {
      @Override
      public int compare(Stationery o1, Stationery o2) {
        int r = (int) (o1.getPrice() - o2.getPrice());
        if (r != 0)
          return r;
        r = o1.getName().compareTo(o2.getName());
        return r;
      }
    });
    return beginnerSet;
  }

}
