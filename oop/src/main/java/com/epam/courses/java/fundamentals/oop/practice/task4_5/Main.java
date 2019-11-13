package com.epam.courses.java.fundamentals.oop.practice.task4_5;

import java.util.Collections;

public class Main {

  public static void main(String[] args) {

    StarterKit starterKit = new StarterKit();

    starterKit.getStationeryList().add(new Pen("pilot", 4, PenType.BALLPOINT, InkColor.BLACK));
    starterKit.getStationeryList().add(new NoteBook("erich", 8, NoteBookType.IN_CAGE));
    starterKit.getStationeryList().add(new Pen("corvina", 3, PenType.BALLPOINT, InkColor.BLUE));
    starterKit.getStationeryList().add(new NoteBook("maestro", 7, NoteBookType.IN_LINE));

    System.out.println("Sort by name");
    Collections.sort(starterKit.getStationeryList(), Stationery.sortByName);
    starterKit.printAllElementsInStarterKit();

    System.out.println("Sort by price");
    Collections.sort(starterKit.getStationeryList(), Stationery.sortByPrice);
    starterKit.printAllElementsInStarterKit();

    System.out.println("Sort by name and price");
    Collections.sort(starterKit.getStationeryList(), Stationery.sortByPriceAndName);
    starterKit.printAllElementsInStarterKit();
  }
}
