package com.epam.courses.java.fundamentals.oop.practice.task6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Group {

  private Subjects subject;
  private Set<Student> students = new HashSet<>();

  public Group(Subjects subject) {
    this.subject = subject;
  }

  public void addStudentInGroup(Student student) {
    if (!(students.contains(student))) {
      students.add(student);
      student.getGroupAndMarkList().put(this, new ArrayList<Number>());
    } else
      throw new IllegalArgumentException(student + " is already in " + this + "!");
  }

  public <T extends Number> void addStudentMark(Student student, T mark) {
    if (students.contains(student)) {
      if (ifPossibleToAddMark(mark))
        student.getGroupAndMarkList().get(this).add(mark);
      else
        throw new IllegalArgumentException("Wrong mark type for " + subject + "!");
    } else
      throw new IllegalArgumentException("There is no " + student + " in " + this + "!");
  }

  private <T extends Number> boolean ifPossibleToAddMark(T mark) {
    return mark.getClass().equals(subject.getMarkType());
  }

  @Override
  public String toString() {
    return "" + subject;
  }
}
