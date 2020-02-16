package com.epam.courses.java.fundamentals.oop.practice.task4_task5;

import com.epam.courses.java.fundamentals.oop.demo.Employee;
import com.epam.courses.java.fundamentals.oop.practice.task2.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StarterPack {

  private static Stuff[] coolArrayStuff = {
      new Pen(1,80, "Start-pen","PILOT", typesOfPen.BALLPOINT),
      new Pencil(30,"EPAM systems","KNOR",1, typesOfPencil.GRAPHITE),
      new Paper(100,7,"EPAM systems","SvetoCopy"),
      new Ruler(90,"EPAM systems","RegRuler",20, materialForRuler.PLASTIC)
  };

  private static List<Stuff> starterPack = new ArrayList<>(Arrays.asList(coolArrayStuff));

  static void addStarterPackToEmployee(Employee employee){
    employee.addPack(starterPack);
    System.out.println("Starter pack is added");
  }

  static void showAllStuf(){
    int count = 0;
    for (Stuff stuff : starterPack
    ) {
      System.out.print("[" + count + "] ");
      System.out.println(stuff.toString());
      count++;
    }
    System.out.println();
  }

  static int getAllStuffPrice(){
    int allPrice = 0;
    for (Stuff stuff : starterPack
    ) {
      allPrice+=stuff.getPrice();
    }
    return allPrice;
  }

  static void sortByPrice(){
    starterPack.sort(Comparator.comparing(Stuff::getPrice));
    System.out.println("Starter pack sorted by price:\n" + starterPack);
  }

  static void sortByName(){
    starterPack.sort(Comparator.comparing(Stuff::getName));
    System.out.println("Starter pack sorted by name:\n" + starterPack);
  }

}
