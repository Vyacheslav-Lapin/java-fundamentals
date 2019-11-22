package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
public class Student {

  private String name;
  private HashMap<Group, List<Number>> groupAndMarkList = new HashMap<>();

  public Student(String name) {
    this.name = name;
  }

  public void showGroups() {
    if (groupAndMarkList.isEmpty())
      System.out.println("List of groups for " + this + " is empty!");
    else
      System.out.println(this + " is in groups: " + groupAndMarkList);
  }

  public double GPA(Group group) {
    double sum = 0.0;

    if (group.getStudents().contains(this)) {
      List<Number> marks = groupAndMarkList.get(group);
      for (var number : marks)
        sum += number.doubleValue();

      return sum / marks.size();
    } else
      throw new IllegalArgumentException("There is no " + this + " in " + group + "!");
  }

  @Override
  public String toString() {
    return "" + name;
  }
}
