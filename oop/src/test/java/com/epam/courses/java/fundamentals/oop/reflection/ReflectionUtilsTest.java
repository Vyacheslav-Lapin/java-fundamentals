package com.epam.courses.java.fundamentals.oop.reflection;

import static com.epam.courses.java.fundamentals.oop.reflection.ReflectionUtils.getTypesFromPackage;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReflectionUtilsTest {

  @Test
  void getTypesFromPackageTest() {
    assertThat(getTypesFromPackage("com.epam.courses.java.fundamentals.oop.reflection"))
        .isNotNull()
        .hasSize(3)
        .containsExactlyInAnyOrder(ReflectionUtils.class, ReflectionUtilsTest.class, ProxyUtils.class);
  }
}
