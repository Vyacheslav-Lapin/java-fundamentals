package com.epam.courses.java.fundamentals.oop.practice.task3;

import com.epam.courses.java.fundamentals.oop.demo.Employee;

public class OficeAccounting {

  public static void main(String[] __){
    Employee employee = new Employee("Greatest mployee",41,176,1_000_000);
    countingOficeStuff(employee);
  }

  public static void countingOficeStuff(Employee employee){
    System.out.println("Total cost of employee stationery: " + employee.getAllStuffPrice());
  }

}
