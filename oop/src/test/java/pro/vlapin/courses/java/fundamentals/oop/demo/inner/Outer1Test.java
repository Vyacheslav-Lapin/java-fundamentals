package pro.vlapin.courses.java.fundamentals.oop.demo.inner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import lombok.val;
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
