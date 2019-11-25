package com.epam.courses.java.fundamentals.oop.practice.task4;

import com.epam.courses.java.fundamentals.oop.practice.task3.Stationery.Stationery;
import com.epam.courses.java.fundamentals.oop.practice.task3.StationerySet;
import lombok.experimental.NonFinal;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Используйте «набор новичка», созданный в задании 3, (или любую другую коллекцию объектов);
 * отсортируйте вещи в этом наборе по стоимости, по наименованию, по стоимости и наименованию.
 */

public class SortedNewbySet {

  private static ArrayList<Stationery> basicList = StationerySet.getFullNewbySet();

  private ArrayList<Stationery> sortedList;

  enum SORTBY {PRICE, NAME, NAME_PRICE}

  private SortedNewbySet(SORTBY sortOrder) {
    this.sortedList = new ArrayList<>();
    if (sortOrder == SORTBY.PRICE) basicList.stream().
        sorted(Comparator.comparingDouble(Stationery::getPrice)).
        forEach(sortedList::add);
    else if (sortOrder == SORTBY.NAME) basicList.stream().
        sorted(Comparator.comparing(e -> e.getClass().getSimpleName())).
        forEach(sortedList::add);
    else if (sortOrder == SORTBY.NAME_PRICE) basicList.stream().
        sorted(Stationery::compareTo).forEach(sortedList::add);
  }

  private String getSortedList() {
    StringBuilder s = new StringBuilder();
    for (Stationery stat : sortedList) s.append(stat).append("\n");
    return s.toString();
  }

  public static void main(String[] args) {
    SortedNewbySet byPrice = new SortedNewbySet(SORTBY.PRICE);
    SortedNewbySet byName = new SortedNewbySet(SORTBY.NAME);
    SortedNewbySet byNamePrice = new SortedNewbySet(SORTBY.NAME_PRICE);
    System.out.println(byNamePrice.getSortedList());
  }
}
