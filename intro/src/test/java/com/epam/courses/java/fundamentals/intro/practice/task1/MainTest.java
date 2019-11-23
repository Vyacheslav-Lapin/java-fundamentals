package com.epam.courses.java.fundamentals.intro.practice.task1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.courses.java.fundamentals.intro.commons.TestUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  @Disabled
  @DisplayName("Main method works correctly")
  void main() {
    assertThat(TestUtils.fromSystemOutPrintln(Main::main))
        .isEqualTo("I am string in Logic class.");
  }
}
