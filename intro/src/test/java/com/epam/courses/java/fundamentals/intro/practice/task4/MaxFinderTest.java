package com.epam.courses.java.fundamentals.intro.practice.task4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxFinderTest {

  @Test
  @Disabled
  @DisplayName("GetMaximum method works correctly")
  void getMaximum() {
    assertThat(new MaxFinder(0.1, 0.5, 58, 34, 0.6, 20).getMaximum())
        .isEqualTo(92);
  }
}
