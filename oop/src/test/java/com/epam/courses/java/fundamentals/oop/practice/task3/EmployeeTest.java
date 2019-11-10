package com.epam.courses.java.fundamentals.oop.practice.task3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

  private static Employee employee1;
  private static Employee employee2;

  @BeforeAll
  static void setUp() {
    employee1 = new Employee("Employee 1");
    employee2 = new Employee("Employee 2");

    employee1.getStationery().add(new Pen(4, 2, PenType.BALLPOINT));
    employee2.getStationery().add(new Pen(10,1, PenType.GEL));
  }

  @Test
  @DisplayName("getStationaryCost method works correctly")
  void testGetStationaryCost() {
    assertThat(employee1.getStationeryCost()).isEqualTo(8);
    assertThat(employee2.getStationeryCost()).isEqualTo(10);
  }
}
