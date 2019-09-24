package com.epam.courses.java.fundamentals.intro.practice.task2;

import static com.epam.courses.java.fundamentals.intro.commons.TestUtils.fromSystemOutPrintln;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinFinderTest {

  @Test
  @DisplayName("Main method works correctly")
  void Main() {
    assertThat(fromSystemOutPrintln(MinFinder::main))
        .isEqualTo("""
            0.25
            0.1111111111111111
            Минимальный индекс: 3.0""");
  }
}
