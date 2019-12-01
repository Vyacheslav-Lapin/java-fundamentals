package com.epam.courses.java.fundamentals.oop.practice.task5;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
class Group {

  enum Discipline {HISTORY, HIGHERMATH, NUMMETHODS}

  enum Tutor {IVANOFF, PETROFF, SMIRNOFF, KOUZNETSOFF}

  Group.Discipline discipline;

  Group.Tutor tutor;

  Map<Student, ArrayList<Double>> marks;

  boolean markIsInteger;

  Group(Discipline discipline, Tutor tutor, boolean markIsInteger) {
    this.discipline = discipline;
    this.tutor = tutor;
    this.markIsInteger = markIsInteger;
    this.marks = new HashMap<>();
  }

  private void AddToGroup(Student student) {
    if (!marks.isEmpty()&&marks.containsKey(student)) return;
    marks.put(student, new ArrayList<>());
    student.addGroup(this);
  }

  Group addMark(Student student, int mark) {
    return addMark(student, (double) mark);
  }

  Group addMark(Student student, double mark) {
    if (marks.isEmpty()||!marks.containsKey(student)) AddToGroup(student);
    marks.get(student).add(mark);
    student.addMark(this, mark);
    return this;
  }

  HashMap<Student, String> allMarksAsString(){
    HashMap<Student, String> marksAsString = new HashMap<>();
    for (Student student: marks.keySet()){
      StringBuilder s = new StringBuilder();
      if(markIsInteger) marks.get(student).stream().
          mapToLong(Double::longValue).
          mapToObj(String::valueOf).
          map((h)->h+",").
          forEach(s::append);
      else marks.get(student).stream().map(String::valueOf).map((h)->h+", ").forEach(s::append);
      marksAsString.put(student, s.toString());
    }
    return marksAsString;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(discipline).
        append(": \nTutor: ").
        append(tutor).
        append("\nStudents and marks:");
    HashMap<Student, String> marksAsString = allMarksAsString();
    for (Student student: marksAsString.keySet()){
      s.append("\n").
          append(student.getFullname()).
          append(": ").
          append(marksAsString.get(student));
    }
    return s.toString();
  }
}
