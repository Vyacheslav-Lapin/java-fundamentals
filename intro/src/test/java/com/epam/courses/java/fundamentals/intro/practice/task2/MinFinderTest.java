package com.epam.courses.java.fundamentals.intro.practice.task2;

import static com.epam.courses.java.fundamentals.intro.commons.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinFinderTest {

  @Test
  @Disabled
  @DisplayName("Main method works correctly")
  void mainMethodWorksCorrectlyTest() {
    assertThat(fromSystemOutPrintln(MinFinder::main))
        .isEqualTo("""
            0.25
            0.1111111111111111
            Минимальный индекс: 3.0""");
  }
}
