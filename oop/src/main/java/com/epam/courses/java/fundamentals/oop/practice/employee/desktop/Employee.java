package com.epam.courses.java.fundamentals.oop.practice.employee.desktop;

public class Employee {
  private int id;
  private String firstName;
  private String lastName;

  public int getId() {
    return id;
  }

  public Employee(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
