package com.epam.courses.java.fundamentals.intro;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.courses.java.fundamentals.intro.commons.TestUtils;
import com.epam.courses.java.fundamentals.intro.demo.Hello;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloTest {

  @Test
  @Disabled
  @DisplayName("main method works correctly")
  void main() {
    assertThat(TestUtils.fromSystemOutPrintln(Hello::main))
        .endsWith("Hello, world!");
  }
}
