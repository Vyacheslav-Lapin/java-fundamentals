package com.epam.courses.java.fundamentals.oop.demo.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PackageUtilTest {

  @Test
  @SneakyThrows
  @DisplayName("classes method works correctly")
  void classesMethodWorksCorrectlyTest() {
    assertThat(PackageUtil.classes("com.epam.courses.java.fundamentals.oop.demo.reflection"))
        .containsExactlyInAnyOrder(PackageUtil.class, PackageUtilTest.class);
  }
}
