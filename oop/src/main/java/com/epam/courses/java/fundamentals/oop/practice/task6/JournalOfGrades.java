package com.epam.courses.java.fundamentals.oop.practice.task6;

import com.epam.courses.java.fundamentals.oop.demo.superbuilder.Student;

import java.util.HashMap;

public class JournalOfGrades {
  private HashMap<Student, HashMap<Subject,Mark>> journal = new HashMap<>();

  public void addMArk(Student student, Subject subject, Mark mark){
    HashMap<Subject,Mark> subjectsAndMarks = new HashMap<>();
    subjectsAndMarks.put(subject,mark);
    journal.put(student, subjectsAndMarks);
  }

  public HashMap<Student, HashMap<Subject, Mark>> getJournal() {
    return journal;
  }

}
