package com.epam.courses.java.fundamentals.oop.demo.superbuilder;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.val;
import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  void create() {
    val student = Student.builder()
                      .parentName("Andrea")
                      .parentAge(38)
                      .childName("Emma")
                      .childAge(6)
                      .schoolName("Baeldung High School")
                      .build();

    assertThat(student.getChildName()).isEqualTo("Emma");
    assertThat(student.getChildAge()).isEqualTo(6);
    assertThat(student.getParentName()).isEqualTo("Andrea");
    assertThat(student.getParentAge()).isEqualTo(38);
    assertThat(student.getSchoolName()).isEqualTo("Baeldung High School");
  }
}
