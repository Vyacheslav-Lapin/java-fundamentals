package com.epam.courses.java.fundamentals.oop.practice.task2.university;

public class Group {

  Subject subject;

  Group(Subject subject) {
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }

  @Override
  public String toString() {
    return "Group{" +
        "subject=" + subject +
        '}';
  }
}
