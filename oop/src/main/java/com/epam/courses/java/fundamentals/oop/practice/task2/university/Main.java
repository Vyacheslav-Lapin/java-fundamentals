package com.epam.courses.java.fundamentals.oop.practice.task2.university;

public class Main {

  public static void main(String[] args) {
    Group java = new Group(Subject.JAVA);
    Group python = new Group(Subject.PYTHON);
    Group javascript = new Group(Subject.JAVASCRIPT);
    Student alex = new Student("Alex");
    Student victor = new Student("Victor");
    Student den = new Student("Den");
    alex.addToGroup(java);
    alex.addToGroup(python);
    alex.addToGroup(javascript);
    System.out.println(alex.getGroups());
  }
}
