package com.epam.courses.java.fundamentals.oop.practice.task6;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

  public static Student find(String name, ArrayList<Student> people) {
    for (Student e : people) {
      if (e.getName().equals(name)) {
        return e;
      }
    }
    throw new RuntimeException("No such student");
  }

  public static void main(String[] args) {
    Student st = new Student("Petrov");
    Student st1 = new Student("Ivanov");
    Student st2 = new Student("Sidorov");

    st.addSubject(Subject.LANGUAGES);
    st.addSubject(Subject.CHEMISTRY);
    st.addMark(Subject.CHEMISTRY, 5.0);
    st.addMark(Subject.LANGUAGES, 4);
    st.addMark(Subject.CHEMISTRY, 3.2);
    st.addMark(Subject.CHEMISTRY, 2.6);
    st.addMark(Subject.LANGUAGES, 2);

    st1.addSubject(Subject.MATHEMATICS);
    st1.addMark(Subject.MATHEMATICS, 3.1);
    st1.addMark(Subject.MATHEMATICS, 5.0);
    st1.addSubject(Subject.BIOLOGY);
    st1.addMark(Subject.BIOLOGY, 3);

    st2.addSubject(Subject.CHEMISTRY);
    st2.addSubject(Subject.LANGUAGES);
    st2.addMark(Subject.CHEMISTRY, 3.1);
    st2.addMark(Subject.CHEMISTRY, 3.5);
    st2.addMark(Subject.CHEMISTRY, 3.7);
    st2.addMark(Subject.LANGUAGES, 4);
    st2.addMark(Subject.LANGUAGES, 5);

    ArrayList<Student> people = new ArrayList<>();
    people.add(st);
    people.add(st1);
    people.add(st2);

    while (true) {

      System.out.print("Enter show and name to see student's subjects ");
      System.out.print("or compare and name to see student's best subject: ");

      Scanner in = new Scanner(System.in);
      String choice = in.next();
      String name = in.next();
      switch (choice) {
        case "show":
          Student stud = find(name, people);
          System.out.println(stud.getSubjects());
          break;
        case "compare":
          Student student = find(name,people);
          student.compareMarks();
          break;
      }
    }
  }
}
