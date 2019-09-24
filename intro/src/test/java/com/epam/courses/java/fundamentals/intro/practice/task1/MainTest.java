package com.epam.courses.java.fundamentals.intro.practice.task1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.epam.courses.java.fundamentals.intro.commons.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  @DisplayName("Main method works correctly")
  void main() {
    assertThat(TestUtils.fromSystemOutPrintln(Main::main))
        .isEqualTo("I am string in Logic class.");
  }
}
