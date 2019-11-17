package com.epam.courses.java.fundamentals.oop.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StationerySorterTest {
  Office of = new Office();
  StationerySorter sorter = new StationerySorter();
  ArrayList<Stationery> starterKit = of.createStarterKit();

  @Test
  void sortingByNameTest(){
    List<Stationery> actualSortedByName = sorter.sortByName(starterKit);
    List<Stationery> expectedSortedByName = Arrays.asList(new BallPen(), new Eraser(), new GelPen(), new InkPen(), new Notebook(), new Pencil());
    assertEquals(actualSortedByName, expectedSortedByName);

  }



  @Test
  void sortingByPriceTest(){

    List<Stationery> actualSortedByPrice= sorter.sortByPrice(starterKit);
    List<Stationery> expectedSortedByPrice = Arrays.asList(new Eraser(), new BallPen(), new Notebook(), new GelPen(),  new InkPen(), new Pencil());
    assertEquals(actualSortedByPrice, expectedSortedByPrice);
  }

  @Test
  void sortingByNameAndPrice(){
    List<Stationery> actualSortedByPriceAndName= sorter.sortByPriceAndName(starterKit);
    List<Stationery> expectedSortedByPriceAndName= Arrays.asList( new Eraser(), new BallPen(), new Notebook(), new GelPen(),  new InkPen(), new Pencil());
    assertEquals(actualSortedByPriceAndName, expectedSortedByPriceAndName);
  }
}
