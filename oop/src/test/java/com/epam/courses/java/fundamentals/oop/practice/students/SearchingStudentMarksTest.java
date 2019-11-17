package com.epam.courses.java.fundamentals.oop.practice.students;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchingStudentMarksTest {

  @Test
  void searchingStudentMarksTest(){
    GradeBook gb = new GradeBook();
    gb.addMark(new Student("Smith"), Subject.Biology, new DoubleMark(4.5));
    gb.addMark(new Student("Ooka"), Subject.Geography, new DoubleMark(4));
    gb.addMark(new Student("Smith"), Subject.PT, new IntMark(5));

    Map<Subject, Mark> actualMarks = gb.getStudentMarks(new Student("Smith"));
    Map<Subject, Mark> expectedMarks = Map.of(Subject.Biology, new DoubleMark(4.5), Subject.PT, new IntMark(5));
    assertEquals(expectedMarks, actualMarks);


  }
}
