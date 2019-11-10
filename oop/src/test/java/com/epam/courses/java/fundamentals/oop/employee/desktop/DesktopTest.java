package com.epam.courses.java.fundamentals.oop.employee.desktop;

import com.epam.courses.java.fundamentals.oop.practice.employee.desktop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DesktopTest {

  Employee smith = new Employee(1, "John", "Smith");
  Employee yamashita = new Employee(2, "Yousuke", "Yamashita");
  Office of = new Office(smith, yamashita);


  DesktopTest(){
    of.addStationery(smith.getId(), new Pencil(), new Notebook(), new Eraser());
    of.addStationery(yamashita.getId(), new Pencil(), new Notebook());
  }

  @Test
  void calculateStationeryCostTest() {
    assertEquals (of.calculateStationeryCost(smith), 42);
    assertEquals (of.calculateStationeryCost(yamashita), 38);
  }


}
