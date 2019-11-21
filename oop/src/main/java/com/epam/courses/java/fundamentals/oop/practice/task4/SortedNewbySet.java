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

  @NonFinal
  private ArrayList<Stationery> sortedList;

  public enum SORTBY {PRICE, NAME, NAME_PRICE}

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

  public ArrayList<Stationery> getSortedList() {
    return this.sortedList;
  }

  public static void main(String[] args) {
    ArrayList<Stationery> newArrPrice = new SortedNewbySet(SORTBY.PRICE).getSortedList();
    newArrPrice.stream().map(Stationery::getPrice).forEach(System.out::println);

    ArrayList<Stationery> newArrName = new SortedNewbySet(SORTBY.NAME).getSortedList();
    newArrName.stream().map((e) -> e.getClass().getSimpleName()).forEach(System.out::println);

    ArrayList<Stationery> newArrNamePrice = new SortedNewbySet(SORTBY.NAME_PRICE).getSortedList();
    newArrNamePrice.stream().map(Stationery::getPrice).forEach(System.out::println);
  }
}
