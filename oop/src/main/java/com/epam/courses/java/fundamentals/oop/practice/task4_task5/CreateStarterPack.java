package com.epam.courses.java.fundamentals.oop.practice.task4_task5;

import com.epam.courses.java.fundamentals.oop.demo.Employee;

public class CreateStarterPack {

  public static void main(String[] __ ){
    createAndAddStarterPack();
  }

  public static void createAndAddStarterPack(){
    StarterPack.showAllStuf();
    System.out.println("All starter pack price: " + StarterPack.getAllStuffPrice());
    StarterPack.sortByName();
    StarterPack.showAllStuf();
    StarterPack.sortByPrice();
    StarterPack.showAllStuf();
    Employee employee = new Employee("Great man",40,184,1_000_000);
    StarterPack.addStarterPackToEmployee(employee);
  }

}
