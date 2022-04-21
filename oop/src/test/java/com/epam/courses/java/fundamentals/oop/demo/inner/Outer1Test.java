package com.epam.courses.java.fundamentals.oop.demo.inner;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.time.LocalDate;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Outer1Test {

  @Test
  @DisplayName("Inner classes works correctly")
  void innerClassesWorksCorrectlyTest() {
    val date = LocalDate.now();
    final String str = "lorem";
    final Outer1.Inner inner = new Outer1(str, date).new Inner();
    assertThat(inner.method())
        .isEqualTo("""
            str: %s
            date: %s""".formatted(str, date));
  }
}
