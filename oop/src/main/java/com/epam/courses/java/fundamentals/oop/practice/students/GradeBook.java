package com.epam.courses.java.fundamentals.oop.practice.students;

import java.util.HashMap;
import java.util.Map;

public class GradeBook {
  private HashMap<Student, HashMap<Subject, Mark>> entries = new HashMap<>();
  public void addMark(Student student, Subject subject, Mark mark) {
    entries.computeIfAbsent(student, st -> new HashMap<>()).put(subject, mark);
  }

  public Map<Subject, Mark> getStudentMarks(Student student) {
    return entries.get(student);
  }
}
