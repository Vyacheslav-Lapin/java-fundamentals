package ru.vlapin.courses.java.fundamentals.epam.intro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

  @Test
  @DisplayName("main method works correctly")
  void main() {
    String actual = TestUtils.fromSystemOutPrintln(Hello::main);
    assertThat(actual)
        .isEqualTo("Hello, world!");
  }
}
