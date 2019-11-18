package com.epam.courses.java.fundamentals.oop.practice.task2;

import java.util.ArrayList;
import java.util.Comparator;

public class StrarterPack {
  ArrayList<Stuff> starterPack = new ArrayList<>();

  public ArrayList<Stuff> createStarterpack(){
    starterPack.add(new Pen(1,80, "Start-pen","PILOT",typesOfPen.BALLPOINT));
    starterPack.add(new Pencil(30,"EPAM systems","KNOR",1,typesOfPencil.GRAPHITE));
    starterPack.add(new Paper(100,7,"EPAM systems","SvetoCopy"));
    starterPack.add(new Ruler(90,"EPAM systems","RegRuler",20, materialForRuler.PLASTIC));
    return starterPack;
  }

  public void showAllStuf(){
    int count = 0;
    for (Stuff stuff : starterPack
    ) {
      System.out.print("[" + count + "] ");
      System.out.println(stuff.toString());
      count++;
    }
  }

  public int getAllStuffPrice(){
    int allPrice = 0;
    for (Stuff stuff : starterPack
    ) {
      allPrice+=stuff.getPrice();
    }
    return allPrice;
  }

  public void sortByPrice(){
    starterPack.sort(Comparator.comparing(Stuff::getPrice));
    System.out.println("Starter pack sorted by price:\n" + starterPack);
  }

  public void sortByName(){
    starterPack.sort(Comparator.comparing(Stuff::getName));
    System.out.println("Starter pack sorted by name:\n" + starterPack);
  }


}
