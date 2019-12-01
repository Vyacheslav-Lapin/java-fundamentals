package com.epam.courses.java.fundamentals.oop.practice.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {

  String fullname;

  String courseGroup;

  Map<Group, List<Double>> allMarks;

  Student(String fullname, String courseGroup) {
    this.fullname = fullname;
    this.courseGroup = courseGroup;
    this.allMarks = new HashMap<>();
  }

  String getFullname() {
    return fullname;
  }

  void addGroup(Group group){
    if (!allMarks.isEmpty()&&allMarks.containsKey(group)) return;
    allMarks.put(group, new ArrayList<>());
  }

  void addMark(Group group, double mark) {
    if (allMarks.isEmpty()||!allMarks.containsKey(group)) addGroup(group);
    allMarks.get(group).add(mark);
  }

  String allGroups(){
    StringBuilder s = new StringBuilder();
    for (Group group: allMarks.keySet()){
      s.append("\n").
          append(group.getDiscipline()).
          append(" (").
          append(group.getTutor()).
          append(")");
    }
    return s.toString();
  }

  private HashMap<Group, String> allMarksAsString(){
    HashMap<Group, String> marksAsString = new HashMap<>();
    StringBuilder s = new StringBuilder();
    for (Group group: allMarks.keySet()){
      s.append("\n").
          append(group.getDiscipline()).
          append(" (").
          append(group.getTutor()).
          append("): ").
          append(group.allMarksAsString().get(this));
      marksAsString.put(group, s.toString());
    }
    return marksAsString;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(fullname).
        append("(").
        append(courseGroup).
        append("):");
    HashMap<Group, String> marksAsString = allMarksAsString();
    for (Group group: marksAsString.keySet()){
      s.append(marksAsString.get(group));
    }
    return s.toString();
  }
}
