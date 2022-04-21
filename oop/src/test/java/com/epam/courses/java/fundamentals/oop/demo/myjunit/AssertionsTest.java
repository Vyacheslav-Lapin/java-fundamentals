package com.epam.courses.java.fundamentals.oop.demo.myjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssertionsTest {

  @Test
  @DisplayName("Assertions class works correctly")
  void main() {
    Assertions.main(getClass().getName());
  }

  @com.epam.courses.java.fundamentals.oop.demo.myjunit.Test("Assertions works correctly")
  void assertionsWorksCorrectlyTest() {
    System.out.println("I'm called!");
  }
}
