package com.epam.courses.java.fundamentals.oop.practice.task2.university;

import java.util.ArrayList;
import java.util.List;

public class Student {

  private String name;
  List<Group> groups;

  Student(String name) {
    this.name = name;
    groups = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Group> getGroups() {
    return groups;
  }

  public void addToGroup(Group group) {
    groups.add(group);
  }

  public void setEstimate(Subject subject) {

  }


  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", groups=" + groups +
        '}';
  }
}
