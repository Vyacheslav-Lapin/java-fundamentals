package com.epam.courses.java.fundamentals.oop.practice.task6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentTest {

  private static Student student_1 = new Student("Student_1");
  private static Student student_2 = new Student("Student_2");
  private static Student student_3 = new Student("Student_3");
  private static Student student_4 = new Student("Student_4");
  private static Student student_5 = new Student("Student_5");
  private static Student student_6 = new Student("Student_6");
  private static Student student_7 = new Student("Student_7");

  private static Group group_CS = new Group(Subjects.COMPUTER_SCIENCE);
  private static Group group_ST = new Group(Subjects.SOFTWARE_TESTING);
  private static Group group_WT = new Group(Subjects.WEB_TECHNOLOGY);
  private static Group group_EN = new Group(Subjects.ENGLISH);

  @BeforeAll
  static void groupForming() {
    group_CS.addStudentInGroup(student_4);
    group_CS.addStudentInGroup(student_5);
    group_CS.addStudentInGroup(student_6);

    group_ST.addStudentInGroup(student_1);
    group_ST.addStudentInGroup(student_4);
    group_ST.addStudentInGroup(student_3);

    group_WT.addStudentInGroup(student_5);
    group_WT.addStudentInGroup(student_2);
    group_WT.addStudentInGroup(student_6);

    group_EN.addStudentInGroup(student_2);
    group_EN.addStudentInGroup(student_3);
    group_EN.addStudentInGroup(student_4);

    group_CS.addStudentMark(student_4, 3.8);
    group_CS.addStudentMark(student_5, 4.6);

    group_WT.addStudentMark(student_2, 4.5);
    group_WT.addStudentMark(student_2, 5.0);

    group_EN.addStudentMark(student_2, 4);
    group_EN.addStudentMark(student_3, 3);
    group_EN.addStudentMark(student_4, 5);
  }

  @Test
  @DisplayName("addStudentInGroup method works correctly")
  void testAddStudentInGroup() {
    assertThat(student_2.getGroupAndMarkList().size()).isEqualTo(2);
    assertThat(student_4.getGroupAndMarkList().size()).isEqualTo(3);
    assertThat(student_7.getGroupAndMarkList().size()).isEqualTo(0);
  }

  @Test
  @DisplayName("GPA method works correctly")
  void testGPA() {
    assertThat(student_2.GPA(group_WT)).isEqualTo(4.75);
    assertThat(student_2.GPA(group_EN)).isEqualTo(4);
    assertThat(student_4.GPA(group_CS)).isEqualTo(3.8);
  }
}
