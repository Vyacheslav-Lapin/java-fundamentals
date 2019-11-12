package com.epam.courses.java.fundamentals.oop.practice.task4;

import java.util.ArrayList;
import java.util.Comparator;

public class ForStaff {
  ArrayList<Staff> starterKit = new ArrayList<>();

  public ArrayList<Staff> createStarterKit() {

    starterKit.add(new Paper("Paper", 13));
    starterKit.add(new Pen("Pen", 19));
    starterKit.add(new Sharpener("Sharpener", 41));
    starterKit.add(new Corrector("Corrector", 100));
    starterKit.add(new Pencil("Pencil", 10));

   return starterKit;
  }

  public void getAllStaffPrice() {
    int allPrice = 0;
    for (Staff staff : starterKit
    ) {
      allPrice += staff.getPrice();
    }
    System.out.println("Full price : " + allPrice);
  }

  public void SortByPrice() {
    System.out.println("Sorting by name");
    starterKit.sort(Comparator.comparing(Staff::getName));
    System.out.println(starterKit);
  }

  public void SortByName() {
    System.out.println("Sorting by price");
    starterKit.sort(Comparator.comparing(Staff::getPrice));
    System.out.println(starterKit);
  }

  public void showStaff() {
    for (Staff s : starterKit
    ) {
      System.out.println(starterKit);
    }
  }
}
