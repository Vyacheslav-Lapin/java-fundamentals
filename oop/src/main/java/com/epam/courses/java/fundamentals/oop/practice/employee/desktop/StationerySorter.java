package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StationerySorter {

  public List<Stationery> sortByName(ArrayList<Stationery> starterKit) {

    List<Stationery> sortedStarterKit = starterKit.stream().sorted((st1, st2) -> CharSequence.compare(st1.name(),st2.name())).collect(Collectors.toList());
    return sortedStarterKit;

  }

  public List<Stationery> sortByPrice(ArrayList<Stationery> starterKit) {
   List<Stationery> sortedStarterKit = starterKit.stream().sorted(Comparator.comparingDouble(Stationery::price)).collect(Collectors.toList());
   return sortedStarterKit;
  }

  public List<Stationery> sortByPriceAndName(ArrayList<Stationery> starterKit) {
    List<Stationery> sortedStarterKit = starterKit.stream().sorted((st1, st2) -> {
      int priceCompare = Double.compare(st1.price(), st2.price());

      if(priceCompare !=0)
        return priceCompare;
      int nameCompare =CharSequence.compare(st1.name(),st2.name());
      return nameCompare;



    }).collect(Collectors.toList());
    return  sortedStarterKit;
  }
}
