package com.epam.courses.java.fundamentals.oop.practice.task6;

import com.epam.courses.java.fundamentals.oop.demo.superbuilder.Student;

public class CreateGroupsAndStudents {
  public static void main(String[] args) {
    Group math = new Group(Subject.MATH);
    Group physics = new Group(Subject.PHYSICS);
    Group biology = new Group(Subject.BIOLOGY);
    Student andy = new Student("Sarah",53, "Andy" ,18, "584");
    Student linda = new Student("Marta",44, "Linda", 18, "585");
    andy.addGroup(math);
    andy.addGroup(physics);
    andy.addGroup(biology);
    System.out.println(andy.getGroups() + "\n" + andy.getSubjectsAndMarks());
  }
}
