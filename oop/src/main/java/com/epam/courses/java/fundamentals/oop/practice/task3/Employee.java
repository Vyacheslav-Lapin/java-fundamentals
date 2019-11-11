package com.epam.courses.java.fundamentals.oop.practice.task3;

import java.util.Objects;

public class Employee {
  private int id;
  private String name;
  private String position;

  public Employee(int id, String name, String position) {
    this.id = id;
    this.name = name;
    this.position = position;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }


  public String getPosition() {
    return position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name) &&
        Objects.equals(position, employee.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }

  @Override
  public String toString() {
    return "Employee :" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", position='" + position + '\'' +
        '}' + "\n";
  }
}
